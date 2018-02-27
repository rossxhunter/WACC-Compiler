package wacc.ASTNodes;

import wacc.IdentifierObjects.*;
import wacc.SymbolTable;

import static wacc.Main.ST;

/**
 * Created by Ross on 02/11/2017.
 */
public class FuncDecAST implements ASTNode {
  String returntypename;
  String funcname;
  PARAMLIST parameters;
  FUNCTION funcObj;
  int line;

  public FuncDecAST(String returntypename, String funcname, PARAMLIST parameters, FUNCTION funcObj, int line) {
    this.returntypename = returntypename;
    this.funcname = funcname;
    this.parameters = parameters;
    this.funcObj = funcObj;
    this.line = line;
  }

  public void CheckFunctionNameAndReturnType(){
    TYPE T = (TYPE) ST.lookupAll(returntypename);
    FUNCTION F = (FUNCTION) ST.lookup(funcname);
    if (T == null) {
      System.out.println("Line " + line + ": " + "Invalid type");
      System.exit(200);
    }
    else if (!(T instanceof TYPE)) {
      System.out.println("Line " + line + ": " + "Invalid return type");
      System.exit(200);
      //error!
    }
    else if (F != null) {
      System.out.println("Line " + line + ": " + "Function already defined");
      System.exit(200);
      //error!
    }
    else {
      funcObj = new FUNCTION(T, parameters);
      ST.add(funcname, funcObj);
      ST = new SymbolTable(ST);
      for (int i = 0; i < parameters.getNumParams(); i++) {
        TYPE t = parameters.getParamType(i);
        String ident = parameters.getParamIdent(i);
        VARIABLE v = new VARIABLE(t);
        ST.add(ident, v);
      }
    }
  }

  @Override
  public void Check() {
    CheckFunctionNameAndReturnType();
  }
}