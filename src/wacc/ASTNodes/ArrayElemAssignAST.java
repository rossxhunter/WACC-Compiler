package wacc.ASTNodes;

import wacc.IdentifierObjects.EXPRESSION;
import wacc.IdentifierObjects.IDENTIFIER;
import wacc.IdentifierObjects.TYPE;
import wacc.IdentifierObjects.VARIABLE;

import java.util.List;

import static wacc.Main.ST;

/**
 * Created by Ross on 07/11/2017.
 */
public class ArrayElemAssignAST<T> implements ASTNode {
  TYPE type = null; //temp set to null
  EXPRESSION expr;
  int index;
  int line;
  VARIABLE varObj;

  public ArrayElemAssignAST(String ident, EXPRESSION expr, EXPRESSION indexExpr, int line) {
    this.line = line;
    IDENTIFIER identVar = ST.lookupAll(ident);
    if (identVar == null) {
      System.out.println("Line " + line + ": " + "Variable not declared");
      System.exit(200);
    }
    if (!(identVar instanceof VARIABLE)) {
      System.out.println("Line " + line + ": " + "Can't assign to an identifier which is not a variable");
      System.exit(200);
    }
    TYPE overallType = ((VARIABLE) identVar).getType();
    this.type = new TYPE(overallType.getType().split("\\[", 2)[0]);
    this.expr = expr;
    varObj = new VARIABLE(this.type);
  }

  public TYPE getType() {
    return type;
  }

  @Override
  public void Check() {
    List<TYPE> subExpressionTypes = expr.getSubExpressionTypes();
    for (TYPE t : subExpressionTypes) {
      if (t.getType().compareTo(type.getType()) != 0) {
        System.out.println("Line " + line + ": " + "Incompatible types");
        System.exit(200);
      }
    }
  }

}
