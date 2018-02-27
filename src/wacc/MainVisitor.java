package wacc;

import antlr.WACCParser;
import antlr.WACCParserBaseVisitor;
import wacc.ASTNodes.*;
import wacc.IdentifierObjects.*;

import java.util.ArrayList;
import java.util.List;

import static wacc.Main.ST;
import static wacc.Main.MC;

public class MainVisitor extends WACCParserBaseVisitor<Void> {

  private String currentType;
  private String currentFunction;
  private ArrayList<String> constants = new ArrayList<>();

  public Void visitProgram(WACCParser.ProgramContext ctx) {
    return visitChildren(ctx);
  }

  public Void visitStat(WACCParser.StatContext ctx) {
    return visitChildren(ctx);
  }

  public Void visitStatFunc(WACCParser.StatFuncContext ctx) {
    return visitChildren(ctx);
  }

  public Void visitFunc(WACCParser.FuncContext ctx) {
    String typeName = ctx.type().getText();
    String funcName = ctx.ident().IDENT().getText();
    currentFunction = funcName;
    PARAMLIST params;
    if (ctx.paramList() == null) {
      List<WACCParser.ParamContext> paramList = new ArrayList<>();
      params = new PARAMLIST(paramList);
    } else {
      params = new PARAMLIST(ctx.paramList().param());
    }
    FUNCTION f = new FUNCTION(new TYPE(typeName), params);
    FuncDecAST funcAST = new FuncDecAST(typeName, funcName, params, f, ctx.getStart().getLine());
    funcAST.Check();
    MC.removeLast();
    MC.removeLast();
    MC.add("f_"+funcName+":");
    MC.add("PUSH {lr}");
    visitChildren(ctx);
    return null;
  }

  public Void visitParam(WACCParser.ParamContext ctx){
    visitChildren(ctx);
    return null;
  }

  public Void visitBaseType(WACCParser.BaseTypeContext ctx){
    visitChildren(ctx);
    return null;
  }

  public Void visitAssign(WACCParser.AssignContext ctx) {
    if (ctx.assignLHS().ident() != null && ctx.assignRHS().expr() != null) {
      String ident = ctx.assignLHS().ident().getText();
      EXPRESSION expr = new EXPRESSION(ctx.assignRHS().expr());
      AssignAST assignAST = new AssignAST(ident, expr, ctx.getStart().getLine());
      assignAST.Check();

      if (ctx.assignRHS().expr().pairLit() != null) {
        generateNull();
      } else {
        parseExpr(ctx.assignRHS().expr(), -1);
      }

    } else if (ctx.assignLHS().arrayElem() != null) {
      String ident = ctx.assignLHS().arrayElem().ident().getText();
      EXPRESSION index = new EXPRESSION(ctx.assignLHS().arrayElem().expr());
      EXPRESSION expr = new EXPRESSION(ctx.assignRHS().expr());
      ArrayElemAssignAST arrayElemAssignAST = new ArrayElemAssignAST(ident, expr, index, ctx.getStart().getLine());
      arrayElemAssignAST.Check();
    } else if (ctx.assignLHS().pairElem() != null) {
      String ident = ctx.assignLHS().pairElem().expr().getText();
      EXPRESSION expr = new EXPRESSION(ctx.assignRHS().expr());
      boolean isFirst = ctx.assignLHS().pairElem().FIRST() != null;
      PairElemAssignAST pairElemAssignAST = new PairElemAssignAST(ident, expr, isFirst);
      pairElemAssignAST.Check();
    } else if (ctx.assignRHS().pairElem() != null) {
      String ident = ctx.assignLHS().ident().getText();
      boolean isFirst = ctx.assignRHS().pairElem().FIRST() != null;
      EXPRESSION expr = new EXPRESSION(ctx.assignRHS().pairElem(), isFirst);
      AssignAST assignAST = new AssignAST(ident, expr, ctx.getStart().getLine());
      assignAST.Check();
    } else if (ctx.assignLHS().structField() != null) {
      String ident = ctx.assignLHS().structField().ident(0).getText();
      String field = ctx.assignLHS().structField().ident(1).getText();
      EXPRESSION expr = new EXPRESSION(ctx.assignRHS().expr());
      StructFieldAssignAST structFieldAssignAST = new StructFieldAssignAST(ident, field, expr);
    } else {
      String ident = ctx.assignLHS().ident().getText();
      EXPRESSION expr = new EXPRESSION(ctx.assignRHS().call());
      AssignAST assignAST = new AssignAST(ident, expr, ctx.getStart().getLine());
      assignAST.Check();
    }

    return null;
  }

  public Void visitDeclare(WACCParser.DeclareContext ctx) {
    String type = ctx.type().getText();
    String ident = ctx.ident().getText();
    currentType = type;
    MC.incNumOfVars();
    MC.addVars(ident);
    visitChildren(ctx);
    if (ctx.type().baseType() != null && ctx.assignRHS().expr() != null) {
      EXPRESSION expr = new EXPRESSION(ctx.assignRHS().expr());
      VarDecAST varDecAST = new VarDecAST(type, ident, expr, ctx.getStart().getLine());
      varDecAST.Check();
      if (isConstant(ctx.assignRHS().expr())) {
        constants.add(ident);
      }
      generateDecCode(type, ctx.assignRHS().expr());
    } else if (ctx.type().type() != null) {
      WACCParser.ArrayLitContext arrayLitContext = ctx.assignRHS().arrayLit();
      ArrayDecAST arrayDecAST = new ArrayDecAST(type, ident, arrayLitContext, ctx.getStart().getLine());
      arrayDecAST.Check();
    } else if (ctx.type().pairType() != null) {
      String type1 = ctx.type().pairType().pairElemType(0).getText();
      String type2 = ctx.type().pairType().pairElemType(1).getText();
      PairDecAST pairDecAST = new PairDecAST(type, type1, type2, ident);
      pairDecAST.Check();

      if (ctx.assignRHS().expr() != null) {
        if (ctx.assignRHS().expr().pairLit() != null) {
         generateNull();
        }
      } else {
        generateDecCode(type1, type2, ctx.assignRHS().newPair().expr(0), ctx.assignRHS().newPair().expr(1));
      }

    } else if (ctx.assignRHS().pairElem() != null) {
      boolean isFst = ctx.assignRHS().pairElem().FIRST() != null;
      EXPRESSION expr = new EXPRESSION(ctx.assignRHS().pairElem(), isFst);
      VarDecAST varDecAST = new VarDecAST(type, ident, expr, ctx.getStart().getLine());
      varDecAST.Check();
    } else {
      EXPRESSION expr = new EXPRESSION(ctx.assignRHS().call());
      VarDecAST varDecAST = new VarDecAST(type, ident, expr, ctx.getStart().getLine());
      varDecAST.Check();
    }

    return null;
  }

  private boolean isConstant(WACCParser.ExprContext expr) {
    return expr.boolLit() != null || expr.charLit() != null ||
            expr.intLit() != null || expr.strLit() != null;
  }

  private void generateNull() {
    MC.reserveStack(4);
    String reg = MC.getReg();
    MC.add("LDR r0, =0");
    MC.add("STR " + reg + ", [sp]");
    MC.freeReg(reg);
  }

  private void generateDecCode(String type1, String type2, WACCParser.ExprContext expr1, WACCParser.ExprContext expr2) {
    MC.reserveStack(4);
    String reg1 = MC.getReg();
    String reg2 = MC.getReg();

    MC.add("LDR r0, =8");
    MC.add("BL malloc");
    MC.add("MOV " + reg1 + ", r0");

    parseExpr(expr1, 5, reg2);
    generatePairRes(type1, reg2);

    MC.add("STR r0, [" + reg1 + "]");

    parseExpr(expr2, 5, reg2);
    generatePairRes(type2, reg2);

    MC.add("STR r0, [" + reg1 + ", #4]");
    MC.add("STR " + reg1 + ", [sp]");

  }

  private void generatePairRes(String type, String reg) {
    switch (type) {
      case "int":
        MC.add("LDR r0, =4");
        MC.add("BL malloc");
        MC.add("STR " + reg + ", [r0]");
        break;
      case "char":
        MC.add("LDR r0, =1");
        MC.add("BL malloc");
        MC.add("STRB " + reg + ", [r0]");
        break;
      case "bool":
        MC.add("LDR r0, =1");
        MC.add("BL malloc");
        MC.add("STRB " + reg + ", [r0]");
        break;
    }

  }

  public Void visitRet(WACCParser.RetContext ctx) {
    EXPRESSION e = new EXPRESSION(ctx.expr());
    ST = ST.getEncSymTable();
    FUNCTION f = null;
    List<String> stringIdens = ST.getAll();
    for (String iden : stringIdens) {
      if (ST.lookup(iden) instanceof FUNCTION) {
        f = (FUNCTION) ST.lookup(iden);
      }
    }
    RetAST retAST = new RetAST(f, e, ctx.getStart().getLine());
    retAST.Check();
    if (f.getType().getType().equals("int")) {
      MC.add("LDR r4, ="+ctx.expr().getText());
    }
    MC.add("MOV r0, r4");
    MC.add("POP {pc}");
    return null;
  }

  public Void visitCall(WACCParser.CallContext ctx) {
    String funcName = ctx.ident().getText();
    WACCParser.ArgListContext argListContext = ctx.argList();
    PARAMLIST params;
    if (argListContext != null) {
      params = new PARAMLIST(argListContext);
    } else {
      List<WACCParser.ParamContext> paramList = new ArrayList<>();
      params = new PARAMLIST(paramList);
    }
    CallAST callAST = new CallAST(currentType, funcName, params, ctx.getStart().getLine());
    callAST.Check();
    FUNCTION f = (FUNCTION) ST.lookupAll(funcName);
    switch (f.getType().getType()) {
      case "int":
        MC.reserveStack(4);
        break;
      case "bool":
        MC.reserveStack(1);
        break;
      case "char":
        MC.reserveStack(1);
        break;
      case "string":
        MC.reserveStack(4);
      default:
        break;
    }
    MC.add("SUB sp, sp, #4");
    MC.add("BL f_"+funcName);
    MC.add("MOV r4, r0");
    MC.add("STR r4, [sp]");
    return null;
  }

  public Void visitFree(WACCParser.FreeContext ctx) {
    EXPRESSION expr = new EXPRESSION(ctx.expr());
    FreeAST freeAST = new FreeAST(expr, ctx.getStart().getLine());
    freeAST.Check();
    String reg = MC.getReg();

    MC.add("LDR " + reg + ", [sp]");
    MC.add("MOV r0," + reg);
    MC.add("BL p_free_pair");
    MC.genFreePairString();

    MC.freeReg(reg);
    return null;
  }

  public Void visitPrint(WACCParser.PrintContext ctx) {
    EXPRESSION expr = new EXPRESSION(ctx.expr());
    parseExpr(ctx.expr(), 0);
    return null;
  }

  public Void visitPrintln(WACCParser.PrintlnContext ctx) {
    int line = ctx.getStart().getLine();
    EXPRESSION expr = new EXPRESSION(ctx.expr());
    TYPE T = expr.getType();
    List<TYPE> subExpressionTypes = expr.getSubExpressionTypes();
    for (TYPE t : subExpressionTypes) {
      if (t.getType().compareTo(T.getType()) != 0 && expr.getType().getType().compareTo("bool") != 0) {
        System.out.println("Line " + line + ": " + "Incompatible types");
        System.exit(200);
      }
    }
    parseExpr(ctx.expr(), 0);
    MC.add("BL p_print_ln");
    MC.genPrintlnString();
    return null;
  }

  public Void visitRead(WACCParser.ReadContext ctx) {
    int line = ctx.getStart().getLine();
    if (ctx.assignLHS().ident() == null && ctx.assignLHS().pairElem() == null) {
      System.out.println("Line " + line + ": " + "Can only read in ints and chars");
      System.exit(200);
    }
    if (ctx.assignLHS().ident() != null) {
      String ident = ctx.assignLHS().ident().getText();
      VARIABLE v = (VARIABLE) ST.lookupAll(ident);
      if (v.getType().getType() != "int" && v.getType().getType() != "char") {
        System.out.println("Line " + line + ": " + "Can only read in ints and chars");
        System.exit(200);
      }
    }

    String ident = ctx.assignLHS().ident().getText();
    String type = ((VARIABLE)ST.lookupAll(ident)).getType().getType();
    parseIdent(ident, type, 3);
    return null;
  }

  public Void visitBegin(WACCParser.BeginContext ctx) {
    ST = new SymbolTable(ST);
    MC.enterScopePointer();
    visitChildren(ctx);
    return null;
  }

  public Void visitEnd(WACCParser.EndContext ctx) {
    if (ST.lookup(currentFunction) == null) {
      ST = ST.getEncSymTable();
      if (MC.getInsertSize() != 0) {
        MC.updateInsert();
      }
      MC.freeStack();
    }
    else {
      currentFunction = "";
      MC.add("POP {pc}");
      MC.add(".ltorg");
      MC.add("main:");
      MC.add("PUSH {lr}");
    }
    return null;
  }

  public Void visitExit(WACCParser.ExitContext ctx) {
    int line = ctx.getStart().getLine();
    EXPRESSION expr = new EXPRESSION(ctx.expr());
    TYPE T = expr.getType();
    if (T.getType() != "int") {
      System.out.println("Line " + line + ": " + "Invalid exit type - must be int");
      System.exit(200);
    }
    String reg = MC.getReg();
    if (ctx.expr().intLit() != null) {
      MC.add("LDR " + reg + ", =" + ctx.expr().getText());
    } else {
      MC.add("LDR " + reg + ", " + "[sp]");
    }
    MC.add("MOV r0, " + reg);
    MC.freeReg(reg);
    MC.add("BL exit");
    return null;
  }

  public Void visitIfStat(WACCParser.IfStatContext ctx) {
    EXPRESSION expr = new EXPRESSION(ctx.expr());
    if ((ctx.expr().boolOper() == null || ctx.expr().compareOper() != null) && expr.getType().getType() != "bool") {
      System.exit(200);
    }
    parseIf(ctx);
    return null;
  }

  public Void visitWhileStat(WACCParser.WhileStatContext ctx) {
    EXPRESSION expr = new EXPRESSION(ctx.expr());
    if ((ctx.expr().boolOper() == null || ctx.expr().compareOper() != null) && expr.getType().getType() != "bool") {
      System.exit(200);
    }
    parseWhile(ctx);
    return null;
  }

  public Void visitDoWhileStat(WACCParser.DoWhileStatContext ctx) {
    EXPRESSION expr = new EXPRESSION(ctx.expr());
    if ((ctx.expr().boolOper() == null || ctx.expr().compareOper() != null) && expr.getType().getType() != "bool") {
      System.exit(200);
    }
    parseDoWhile(ctx);
    return null;
  }

  public Void visitForStat(WACCParser.ForStatContext ctx) {
    parseFor(ctx);
    return null;
  }

  public Void visitStruct(WACCParser.StructDecContext ctx) {
    StructAST structAST = new StructAST(ctx.ident(), ctx.fieldList());
    return null;
  }

  public Void visitOrd(WACCParser.OrdContext ctx) {
    return null;
  }

  private void generateDecCode(String type, WACCParser.ExprContext expr) {
    switch (type) {
      case "int":
        MC.reserveStack(4);
        parseExpr(expr, -1);
        break;
      case "bool":
        MC.reserveStack(1);
        parseExpr(expr, -1);
        break;
      case "char":
        MC.reserveStack(1);
        parseExpr(expr, -1);
        break;
      case "string":
        MC.reserveStack(4);
        parseExpr(expr, -1);
      default:
        break;
    }
  }

  private void parseExpr(WACCParser.ExprContext expr, int flag) {
    parseExpr(expr, flag, null);
  }

  // Expression
  private void parseExpr(WACCParser.ExprContext expr, int flag, String cReg) {

    String reg = null;

    if (cReg == null && flag != 5) {
      reg = MC.getReg();
    } else {
      reg = cReg;
    }

    //IntLit
    if (expr.intLit() != null) {
      MC.add("LDR " + reg + ", =" + Integer.parseInt(expr.getText()));
      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL p_print_int");
        MC.genPrintIntString();
      } else if (flag == 1) {
        MC.incBranchNum();
        MC.incBranchNum();
        MC.add("CMP " + reg + ", #0");
        MC.add("BEQ L" + (MC.getBranchNum() - 2));
      } else if (flag == 2) {    // WHILE
        MC.add("CMP " + reg + ", #1");
        MC.add("BEQ L1");
      } else if (cReg == null && flag != 5) {
        MC.addInsert("STR " + reg + ", ");
      }
    }

    //BoolLit
    else if (expr.boolLit() != null) {
      if (expr.boolLit().TRUE() != null) {
        MC.add("MOV " + reg + ", #1");
      } else {
        MC.add("MOV " + reg + ", #0");
      }
      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL p_print_bool");
        MC.genPrintBoolString();
      } else if (flag == 1) {    // IF
        MC.incBranchNum();
        MC.incBranchNum();
        MC.add("CMP " + reg + ", #0");
        MC.add("BEQ L" + (MC.getBranchNum() - 2));
      } else if (flag == 2) {    // WHILE
        MC.add("CMP " + reg + ", #1");
        MC.add("BEQ L1");
      } else if (cReg == null && flag != 5) {
        MC.addInsert("STRB " + reg + ", ");
      }
    }

    //CharLit
    else if (expr.charLit() != null) {
      if(expr.getText().equals("'\\0'")) {
        MC.add("MOV " + reg + ", #0");
      } else {
        MC.add("MOV " + reg + ", #" + expr.getText());
      }
      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL putchar");
        MC.genPrintlnString();
      } else if (cReg == null && flag != 5) {
        MC.addInsert("STRB " + reg + ", ");
      }
    }

    //StringLit
    else if (expr.strLit() != null) {
      int msgNum = MC.getMsgNum();
      MC.incMsgNum();

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word " + (expr.getText().length() - 2) + '\n';
      msg += ".ascii " + expr.getText();
      MC.addMsg(msg);
      MC.add("LDR " + reg + ", =msg_" + msgNum);

      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL p_print_string");
        MC.genPrintString();
      } else if (cReg == null) {
        MC.addInsert("STR " + reg + ", ");
      }
    }

    //pairLit
    else if (expr.pairLit() != null) {
      MC.add("LDR " + reg + ", =0");

      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL p_print_reference");
        MC.genPrintRefString();
      }


    }

    else if (expr.ident() != null) {
      String type = ((VARIABLE)ST.lookupAll(expr.ident().getText())).getType().getType();
      if (cReg != null) {
        parseIdent(expr.ident().getText(), type, flag, reg);
      } else {
        MC.freeReg(reg);
        parseIdent(expr.ident().getText(), type, flag);
      }


    }
    else if (expr.arrayElem() != null) {
      checkArrayBounds(expr.arrayElem().ident().getText(), expr.arrayElem().expr(0));
    }

    //Bool Operator
    else if (expr.boolOper() != null) {
      String reg2 = MC.getReg();
      parseExpr(expr.expr(0), -1, reg);
      parseExpr(expr.expr(1), -1, reg2);

      if (expr.boolOper().AND() != null) {    // Bool Operator AND
        MC.add("AND " + reg + ", " + reg + ", " + reg2);
      } else {                                // Bool Operator OR
        MC.add("ORR " + reg + ", " + reg + ", " + reg2);
      }

      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL p_print_bool");
        MC.genPrintBoolString();
      } else if (flag == 1) {
        MC.incBranchNum();
        MC.incBranchNum();
        MC.add("CMP " + reg + ", #0");
        MC.add("BEQ L" + (MC.getBranchNum() - 2));
      } else if (flag == 2) {    // WHILE
        MC.add("CMP " + reg + ", #1");
        MC.add("BEQ L1");
      } else if (cReg == null) {
        MC.addInsert("STRB " + reg + ", ");
      }

      MC.freeReg(reg2);
    }

    //Unary Operator
    else if (expr.unary() != null) {
      if (expr.unary().unaryOper().NOT() != null) {  // Unary Operator NOT
        parseExpr(expr.unary().expr(), -1, reg);
        MC.add("EOR " + reg + ", " + reg + ", #1");
      }
      else if (expr.unary().unaryOper().MINUS() != null) { // Unary Operator NEG
        MC.add("RSBS " + reg + ", " + reg + ", #0");
        MC.add("BLVS p_throw_overflow_error");
        MC.genOverflowErrorString();
      } else if (expr.unary().unaryOper().ord() != null || expr.unary().unaryOper().CHR() != null) { // Unary Operator ORD/CHR
        parseExpr(expr.unary().expr(), -1, reg);
      }

      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        if (expr.unary().unaryOper().NOT() != null) {
          MC.add("BL p_print_bool");
          MC.genPrintBoolString();
        } else {
          MC.add("BL p_print_int");
          MC.genPrintIntString();
        }
      } else if (flag == 1) {
        MC.incBranchNum();
        MC.incBranchNum();
        MC.add("CMP " + reg + ", #0");
        MC.add("BEQ L" + (MC.getBranchNum() - 2));
      } else if (flag == 2) {    // WHILE
        MC.add("CMP " + reg + ", #1");
        MC.add("BEQ L1");
      } else if (cReg == null) {
        if (expr.unary().unaryOper().NOT() != null) {
          MC.addInsert("STRB " + reg + ", ");
        } else {
          MC.addInsert("STR " + reg + ", ");
        }
      }
    }

    //Binary Operator
    else if (expr.binaryOp1() != null) {
      String reg2 = MC.getReg();
      parseExpr(expr.expr(0), -1, reg);
      parseExpr(expr.expr(1), -1, reg2);
       if (expr.binaryOp1().MULTIPLY() != null) { // Binary Operator MULTIPLY
        MC.add("SMULL " + reg + ", " + reg2 + ", " + reg + ", " + reg2);
        MC.add("CMP " + reg2 + ", " + reg + ", " + "ASR #31");
        MC.add("BLNE p_throw_overflow_error");
        MC.genOverflowErrorString();

      } else if (expr.binaryOp1().DIVIDE() != null) {   // Binary Operator DIVIDE
        MC.add("MOV r0, " + reg);
        MC.add("MOV r1, " + reg2);
        MC.add("BL p_check_divide_by_zero");
        MC.add("BL __aeabi_idiv");
        MC.add("MOV " + reg + ", r0");
        MC.genDivideByZeroString();
      }  else if (expr.binaryOp1().MODULO() != null) {  // Binary Operator MOD
        MC.add("MOV r0, " + reg);
        MC.add("MOV r1, " + reg2);
        MC.add("BL p_check_divide_by_zero");
        MC.add("BL __aeabi_idivmod");
        MC.add("MOV " + reg + ", r1");
        MC.genDivideByZeroString();
      }

      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL p_print_int");
        MC.genPrintIntString();
      } else if (cReg == null) {
        MC.addInsert("STR " + reg + ", ");
      }

      MC.freeReg(reg2);
    }

    else if (expr.binaryOp2() != null) {
      String reg2 = MC.getReg();
      parseExpr(expr.expr(0), -1, reg);
      parseExpr(expr.expr(1), -1, reg2);
      if (expr.binaryOp2().PLUS() != null) {            // Binary Operator PLUS
        MC.add("ADDS " + reg + ", " + reg + ", " + reg2);
        MC.add("BLVS p_throw_overflow_error");
        MC.genOverflowErrorString();
      } else if (expr.binaryOp2().MINUS() != null) {   // Binary Operator MINUS
        MC.add("SUBS " + reg + ", " + reg + ", " + reg2);
        MC.add("BLVS p_throw_overflow_error");
        MC.genOverflowErrorString();
      }

      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL p_print_int");
        MC.genPrintIntString();
      } else if (cReg == null) {
        MC.addInsert("STR " + reg + ", ");
      }

      MC.freeReg(reg2);
    }

    //Compare Operator
    else if (expr.compareOper() != null) {
      String reg2 = MC.getReg();
      parseExpr(expr.expr(0), -1, reg);
      parseExpr(expr.expr(1), -1, reg2);
      MC.add("CMP " + reg + ", " + reg2);
      if (expr.compareOper().GREATER() != null) {   // Comp Operator GREATER
        MC.add("MOVGT " + reg + ", #1");
        MC.add("MOVLE " + reg + ", #0");
      }
      else if(expr.compareOper().GREATEREQ() != null) { // Comp Operator GREATER or EQUAL
        MC.add("MOVGE " + reg + ", #1");
        MC.add("MOVLT " + reg + ", #0");
      }
      else if (expr.compareOper().LESS() != null) {  // Comp Operator LESS
        MC.add("MOVLT " + reg + ", #1");
        MC.add("MOVGE " + reg + ", #0");
      }
      else if(expr.compareOper().LESSEQ() != null) { // Comp Operator LESS or EQUAL
        MC.add("MOVLE " + reg + ", #1");
        MC.add("MOVGT " + reg + ", #0");
      }
      else if (expr.compareOper().EQUALITY() != null) { // Comp Operator EQUALITY
        MC.add("MOVEQ " + reg + ", #1");
        MC.add("MOVNE " + reg + ", #0");
      }
      else if (expr.compareOper().NOTEQ() != null) {    // Comp Operator NOT EQUAL
        MC.add("MOVNE " + reg + ", #1");
        MC.add("MOVEQ " + reg + ", #0");
      }

      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL p_print_bool");
        MC.genPrintBoolString();
      } else if (flag == 1) {
        MC.incBranchNum();
        MC.incBranchNum();
        MC.add("CMP " + reg + ", #0");
        MC.add("BEQ L" + (MC.getBranchNum() - 2));
      } else if (flag == 2) {  // WHILE
        MC.add("CMP " + reg + ", #1");
        MC.add("BEQ L1");
      } else if (cReg == null) {
        MC.addInsert("STRB " + reg + ", ");
      }

      MC.freeReg(reg2);
    }

    //BRACKETS
    else if (expr.LBRAC() != null) {
      parseExpr(expr.expr(0), -1, reg);
      if (flag == 0) {
        MC.add("MOV r0, " + reg);
        MC.add("BL p_print_bool");
        MC.genPrintBoolString();
      } else if (flag == 1) {
        MC.incBranchNum();
        MC.incBranchNum();
        MC.add("CMP " + reg + ", #0");
        MC.add("BEQ L" + (MC.getBranchNum() - 2));
      } else if (flag == 2) {  // WHILE
        MC.add("CMP " + reg + ", #1");
        MC.add("BEQ L1");
      } else if (cReg == null) {
        MC.addInsert("STR " + reg + ", ");
      }
    }

    if (cReg == null && expr.ident() == null && flag != 5) {
      MC.freeReg(reg);
    }
  }

  private void checkArrayBounds(String ident, WACCParser.ExprContext index) {
    ARRAY a = (ARRAY) ST.lookupAll(ident);
    int i = 0;
    if (index.intLit() != null) {
      i = Integer.parseInt(index.intLit().getText());
    }
    if (i < 0 || i >= a.getLength()) {
      System.out.println("Array index out of bounds");
      System.exit(200);
    }
  }

  //If Statement
  private void parseIf(WACCParser.IfStatContext ctx) {
    parseExpr(ctx.expr(), 1);
    int branch1 = MC.getBranchNum() - 2;
    int branch2 = MC.getBranchNum() - 1;
    visitStat(ctx.stat(0));
    MC.add("B L" + (branch2));
    MC.add("L" + (branch1) + ":");
    visitStat(ctx.stat(1));
    MC.add("L" + (branch2) + ":");
  }

  //While Statement
  private void parseWhile(WACCParser.WhileStatContext ctx) {
    MC.add("B L0");
    MC.add("L1:");
    visitStat(ctx.stat());
    MC.add("L0:");
    parseExpr(ctx.expr(), 2);
  }

  //Do-While Statement
  private void parseDoWhile(WACCParser.DoWhileStatContext ctx) {
    visitStat(ctx.stat());
    MC.add("B L0");
    MC.add("L1:");
    visitStat(ctx.stat());
    MC.add("L0:");
    parseExpr(ctx.expr(), 2);
  }

  //For Statement
  private void parseFor(WACCParser.ForStatContext ctx) {
    visitDeclare(ctx.declare());
    MC.add("B L0");
    MC.add("L1:");
    visitStat(ctx.stat());
    visitAssign(ctx.assign());
    MC.add("L0:");
    parseExpr(ctx.expr(), 2);
  }

  //Deal with variables
  /* flag 1 == IF
     flag 2 == WHILE
   */
  private void parseIdent(String ident, String type, int flag) {
    parseIdent(ident, type, flag, null);
  }

  private void parseIdent(String ident, String type, int flag, String cReg) {

    String reg = null;

    if (cReg == null) {
      reg = MC.getReg();
    } else {
      reg = cReg;
    }
    System.out.println(ident);
    int varNum = MC.getVarNum(ident);
    int stackOffset = MC.getNumOfVars() - varNum;
    switch (type) {
      case "int":

        if (flag == 3) {
          MC.add("ADD " + reg + ", sp, #0");
          MC.add("MOV r0, " + reg);
          MC.add("BL p_read_int");
          MC.genReadIntString();
          break;
        }

        if (stackOffset == 0) {
          MC.add("LDR " + reg + ", [sp]");
        } else {
          MC.add("LDR " + reg + ", [sp, #" + (stackOffset * 4) + "]");
        }
        if (flag == 0) {
          MC.add("MOV r0, " + reg);
          MC.add("BL p_print_int");
          MC.genPrintIntString();
        } else if (flag == 1) {
          MC.incBranchNum();
          MC.incBranchNum();
          MC.add("CMP " + reg + ", #0");
          MC.add("BEQ L" + (MC.getBranchNum() - 2));
        } else if (flag == 2) {    // WHILE
          MC.add("CMP " + reg + ", #1");
          MC.add("BEQ L1");
        } else if (cReg == null) {
          MC.addInsert("STR " + reg + ", ");
          //MC.add("STR " + reg + ", [sp, #" + stackOffset + "]");
        }
        break;

      case "bool":
        if (cReg != null) {
          //stackOffset++;
          if(stackOffset == 0) {
            MC.add("LDRSB " + reg + ", [sp]");
          } else {
            MC.add("LDRSB " + reg + ", [sp, #" + stackOffset + "]");
          }
        } else if (flag == 0 || flag == 2) {
          if(stackOffset == 0) {
            MC.add("LDRSB " + reg + ", [sp]");
          } else {
            MC.add("LDRSB " + reg + ", [sp, #" + stackOffset + "]");
          }
        } else {
          if(stackOffset == 0) {
            MC.add("MOV " + reg + ", [sp]");
          } else {
            MC.add("MOV " + reg + ", [sp, #" + stackOffset + "]");
          }
        }

        if (flag == 0) {
          MC.add("MOV r0, " + reg);
          MC.add("BL p_print_bool");
          MC.genPrintBoolString();
        } else if (flag == 1) {  // IF
          MC.incBranchNum();
          MC.incBranchNum();
          MC.add("CMP " + reg + ", #0");
          MC.add("BEQ L" + (MC.getBranchNum() - 2));
        } else if (flag == 2) {  // WHILE
          MC.add("CMP " + reg + ", #1");
          MC.add("BEQ L1");
        } else if (cReg == null) {
          MC.addInsert("STRB " + reg + ", ");
        }

        break;
      case "char":

        if (flag == 3) {
          MC.add("ADD " + reg + ", sp, #0");
          MC.add("MOV r0, " + reg);
          MC.add("BL p_read_char");
          MC.genReadCharString();
          break;
        }


        if (cReg != null) {
          if(stackOffset == 0) {
            MC.add("LDRSB " + reg + ", [sp]");
          } else {
            MC.add("LDRSB " + reg + ", [sp, #" + stackOffset + "]");
          }
        } else if (flag == 3) {
          MC.add("LDRSB " + reg + ", [sp]");
        } else {
          if(stackOffset == 0) {
            MC.add("LDRSB " + reg + ", [sp]");
          } else {
            MC.add("LDRSB " + reg + ", [sp, #" + stackOffset + "]");
          }
        }

        if (flag == 0) {
          MC.add("MOV r0, " + reg);
          MC.add("BL putchar");
          MC.genPrintlnString();
        } else if (flag == 1) {
          MC.incBranchNum();
          MC.incBranchNum();
          MC.add("CMP " + reg + ", #0");
          MC.add("BEQ L" + (MC.getBranchNum() - 2));
        } else if (flag == 2) {    // WHILE
          MC.add("CMP " + reg + ", #1");
          MC.add("BEQ L1");
        } else if (cReg == null){
          MC.addInsert("STRB " + reg + ", ");
        }

        break;
      case "string":
        break;
      default:

        if (stackOffset == 0) {
          MC.add("LDR " + reg + ", [sp]");
        } else {
          MC.add("LDR " + reg + ", [sp, #" + stackOffset + "]");
        }

        if (flag == 0) {
          MC.add("MOV r0, " + reg);
          MC.add("BL p_print_reference");
          MC.genPrintRefString();
        }

        break;
    }

    if (cReg == null) {
      MC.freeReg(reg);
    }

  }

}
