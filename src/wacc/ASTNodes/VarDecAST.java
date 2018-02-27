package wacc.ASTNodes;

import wacc.IdentifierObjects.*;

import java.util.List;

import static wacc.Main.ST;

public class VarDecAST implements ASTNode {
  private String typename;
  private String varname;
  private EXPRESSION expr;
  private int line;

  public VarDecAST(String typename, String varname, EXPRESSION expr, int line) {
    this.typename = typename;
    this.varname = varname;
    this.expr = expr;
    this.line = line;
  }

  @Override
  public void Check() {
    TYPE T = (TYPE) ST.lookupAll(typename);
    VARIABLE V = (VARIABLE) ST.lookup(varname);
    if (T == null) {
      System.exit(200);
      //error!
    }
    else if (!(T instanceof TYPE)) {
      System.exit(200);
      //error!
    }
    else if (!(T.isDeclarable())) {
      System.exit(200);
      //error!
    }
    else if (V != null) {
      System.out.println("Line " + line + ": " + "Variable already declared in the same scope");
      System.exit(200);
      //error!
    }
    else {
      if (expr.getType().getType().compareTo("bool") == 0) {
        if (T.getType().compareTo("bool") != 0) {
          System.out.println("Line " + line + ": " + "Cannot assign bool to non bool");
          System.exit(200);
        }
      }
      else {
        List<TYPE> subExpressionTypes = expr.getSubExpressionTypes();
        for (TYPE t : subExpressionTypes) {
          if (t.getType().compareTo(T.getType()) != 0) {
            System.out.println("Line " + line + ": " + "Incompatible types");
            System.exit(200);
          }
        }
      }
      //System.out.println(varname);
      VARIABLE varObj = new VARIABLE(T);
      ST.add(varname, varObj);
    }
  }

}
