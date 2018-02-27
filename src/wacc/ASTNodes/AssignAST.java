package wacc.ASTNodes;

import wacc.IdentifierObjects.*;

import java.util.List;

import static wacc.Main.ST;

public class AssignAST implements ASTNode {
  
  TYPE type = null; //temp set to null
  EXPRESSION expr;
  int line;
  VARIABLE varObj;

  public AssignAST(String ident, EXPRESSION expr, int line) {
    this.line = line;
    if (ST == null) {
      System.out.println("Line " + line + ": " + "End of program already reached");
      System.exit(200);
    }
    IDENTIFIER identVar = ST.lookupAll(ident);
    if (identVar == null) {
      System.out.println("Line " + line + ": " + "Variable not declared");
      System.exit(200);
    }
    if (!(identVar instanceof VARIABLE)) {
      System.out.println("Line " + line + ": " + "Can't assign to an identifier which is not a variable");
      System.exit(200);
    }
    this.type = ((VARIABLE) identVar).getType();
    this.expr = expr;
    varObj = new VARIABLE(this.type);
  }
  
  public TYPE getType() {
    return type;
  }
  
  @Override
  public void Check() {
    if (expr.getType().getType().compareTo("bool") == 0) {
      if (type.getType().compareTo("bool") != 0) {
        System.out.println("Line " + line + ": " + "Cannot assign bool to non bool");
        System.exit(200);
      }
    }
    else {
      List<TYPE> subExpressionTypes = expr.getSubExpressionTypes();
      for (TYPE t : subExpressionTypes) {
        if (t.getType().compareTo(type.getType()) != 0 && t.getType().compareTo("null") != 0
                && type.getType().compareTo("bool") != 0) {
          System.out.println("Line " + line + ": " + "Incompatible types");
          System.exit(200);
        }
      }
    }
  }

}