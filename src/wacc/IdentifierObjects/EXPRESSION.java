package wacc.IdentifierObjects;

import java.util.ArrayList;
import java.util.List;

import static wacc.Main.ST;

/**
 * Created by Ross on 07/11/2017.
 */
public class EXPRESSION extends IDENTIFIER {

  private List<TYPE> subExpressionTypes = new ArrayList<>();
  private List<TYPE> subExpressionVars = new ArrayList<>();
  private TYPE type;

  public EXPRESSION(List<antlr.WACCParser.ExprContext> exprs) {
    populateSubExpresssionTypes(exprs);
  }

  public EXPRESSION(antlr.WACCParser.ExprContext expr) {
    populateSubExpresssionTypes(expr);
  }

  public EXPRESSION(antlr.WACCParser.PairElemContext expr, boolean isFirst) {
    IDENTIFIER i = ST.lookupAll(expr.expr().ident().getText());
    if (i != null) {
      PAIR pair = (PAIR) i;
      if (isFirst) {
        type =  pair.getFirst();
      }
      else {
        type = pair.getSecond();
      }
      subExpressionTypes.add(type);
    }
    else {
      System.out.println("variable undefined");
      System.exit(200);
    }
  }

  public EXPRESSION(antlr.WACCParser.CallContext call) {
    IDENTIFIER i = ST.lookupAll(call.ident().getText());
    if (i == null) {
      System.out.println("Called function undefined");
      System.exit(200);
    }
    else {
      FUNCTION f = (FUNCTION) i;
      type = f.getType();
      subExpressionTypes.add(type);
    }
  }

  private void populateSubExpresssionTypes(List<antlr.WACCParser.ExprContext> exprs) {
    for (antlr.WACCParser.ExprContext expr : exprs) {
      if (expr.boolOper() != null || expr.compareOper() != null) {
        type = new TYPE("bool");
        EXPRESSION expr1 = new EXPRESSION(expr.expr(0));
        EXPRESSION expr2 = new EXPRESSION(expr.expr(1));
        if (expr1.getType().getType().compareTo(expr2.getType().getType()) != 0 &&
                !(expr1.getType().isPairType() && expr2.getType().getType().compareTo("null") == 0 ||
                        expr2.getType().isPairType() && expr1.getType().getType().compareTo("null") == 0)){
          System.out.println("Inconsistent types");
          System.exit(200);
        }
        if (expr.boolOper() != null && expr1.getType().getType().compareTo("bool") != 0) {
          System.out.println("Must use bool types either side of && and ||");
          System.exit(200);
        }
        if (expr.compareOper() != null && (expr.compareOper().EQUALITY() != null || expr.compareOper().NOTEQ() != null)
                && (expr1.getType().isPairType() || expr2.getType().isPairType())) {

        }
        else if ((expr1.getType().isArrayType() || expr2.getType().isArrayType() ||
                expr1.getType().isPairType() || expr2.getType().isPairType())) {
          System.out.println("Cannot use boolean operations on arrays or pairs");
          System.exit(200);
        }
      }
      if (expr.intLit() != null) {
        subExpressionTypes.add(new TYPE("int"));
      } else if (expr.charLit() != null) {
        subExpressionTypes.add(new TYPE("char"));
      } else if (expr.boolLit() != null) {
        subExpressionTypes.add(new TYPE("bool"));
      } else if (expr.strLit() != null) {
        subExpressionTypes.add(new TYPE("string"));
      } else if (expr.pairLit() != null) {
        subExpressionTypes.add(new TYPE("null"));
      } else if (expr.unary() != null) {
        if (expr.unary().unaryOper().ord() != null) {
          subExpressionTypes.add(new TYPE("int"));
        }
        if (expr.unary().unaryOper().NOT() != null) {
          subExpressionTypes.add(new TYPE("bool"));
        }
        if (expr.unary().unaryOper().CHR() != null) {
          subExpressionTypes.add(new TYPE("char"));
        }
        if (expr.unary().unaryOper().MINUS() != null) {
          subExpressionTypes.add(new TYPE("int"));
        }
        if (expr.unary().unaryOper().LENGTH() != null) {
          subExpressionTypes.add(new TYPE("int"));
        }
      } else if (expr.ident() != null) {
        String varName = expr.ident().getText();
        IDENTIFIER i = ST.lookupAll(varName);
        VARIABLE v = null;
        if (i != null) {
          v = (VARIABLE) i;
        } else {
          System.out.println("Undeclared variable");
          System.exit(200);
        }
        subExpressionTypes.add(v.getType());
      } else if (expr.arrayElem() != null) {
        String varName = expr.arrayElem().ident().getText();
        IDENTIFIER i = ST.lookupAll(varName);
        ARRAY a = null;
        if (i != null) {
          a = (ARRAY) i;
        } else {
          System.out.println("Undeclared variable");
          System.exit(200);
        }
        subExpressionTypes.add(a.getType());
      } else if (expr.expr() != null) {
        populateSubExpresssionTypes(expr.expr());
      } else {
        subExpressionTypes.add(new TYPE("other"));
      }
    }
  }

  private void populateSubExpresssionTypes(antlr.WACCParser.ExprContext expr) {
      if (expr.boolOper() != null || expr.compareOper() != null) {
        type = new TYPE("bool");
        EXPRESSION expr1 = new EXPRESSION(expr.expr(0));
        EXPRESSION expr2 = new EXPRESSION(expr.expr(1));
        if (expr1.getType().getType().compareTo(expr2.getType().getType()) != 0 &&
                !(expr1.getType().isPairType() && expr2.getType().getType().compareTo("null") == 0 ||
                 expr2.getType().isPairType() && expr1.getType().getType().compareTo("null") == 0)){
          System.out.println("Inconsistent types");
          System.exit(200);
        }
        if (expr.boolOper() != null && expr1.getType().getType().compareTo("bool") != 0) {
          System.out.println("Must use bool types either side of && and ||");
          System.exit(200);
        }
        if (expr.compareOper() != null && (expr.compareOper().EQUALITY() != null || expr.compareOper().NOTEQ() != null)
                && (expr1.getType().isPairType() || expr2.getType().isPairType())) {

        }
        else if ((expr1.getType().isArrayType() || expr2.getType().isArrayType() ||
                expr1.getType().isPairType() || expr2.getType().isPairType())) {
          System.out.println("Cannot use boolean operations on arrays or pairs");
          System.exit(200);
        }
      }
    if (expr.intLit() != null) {
      subExpressionTypes.add(new TYPE("int"));
    } else if (expr.charLit() != null) {
      subExpressionTypes.add(new TYPE("char"));
    } else if (expr.boolLit() != null) {
      subExpressionTypes.add(new TYPE("bool"));
    } else if (expr.strLit() != null) {
      subExpressionTypes.add(new TYPE("string"));
    } else if (expr.pairLit() != null) {
      subExpressionTypes.add(new TYPE("null"));
    } else if (expr.unary() != null) {
      if (expr.unary().unaryOper().ord() != null) {
        subExpressionTypes.add(new TYPE("int"));
      }
      if (expr.unary().unaryOper().NOT() != null) {
        subExpressionTypes.add(new TYPE("bool"));
      }
      if (expr.unary().unaryOper().CHR() != null) {
        subExpressionTypes.add(new TYPE("char"));
      }
      if (expr.unary().unaryOper().MINUS() != null) {
        subExpressionTypes.add(new TYPE("int"));
      }
      if (expr.unary().unaryOper().LENGTH() != null) {
        subExpressionTypes.add(new TYPE("int"));
      }
    } else if (expr.ident() != null) {
      String varName = expr.ident().getText();
      IDENTIFIER i = ST.lookupAll(varName);
      VARIABLE v = null;
      if (i != null) {
        v = (VARIABLE) i;
      } else {
        System.out.println("Undeclared variable");
        System.exit(200);
      }
      subExpressionTypes.add(v.getType());
    } else if (expr.arrayElem() != null) {
      String varName = expr.arrayElem().ident().getText();
      IDENTIFIER i = ST.lookupAll(varName);
      VARIABLE v = null;
      if (i != null) {
        v = (VARIABLE) i;
      } else {
        System.out.println("Undeclared variable");
        System.exit(200);
      }
      subExpressionTypes.add(v.getType());
    } else if (expr.expr() != null) {
      populateSubExpresssionTypes(expr.expr());
    } else {
      subExpressionTypes.add(new TYPE("other"));
    }
  }

  public TYPE getType() {
    if (type != null) {
      return type;
    }
    return subExpressionTypes.get(0);
  }

  public List<TYPE> getSubExpressionTypes() {
    return subExpressionTypes;
  }
}
