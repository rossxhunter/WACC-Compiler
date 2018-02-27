package wacc.ASTNodes;

import wacc.IdentifierObjects.EXPRESSION;
import wacc.IdentifierObjects.TYPE;

/**
 * Created by Ross on 07/11/2017.
 */
public class FreeAST implements ASTNode {

  private EXPRESSION expression;
  private int line;

  public FreeAST(EXPRESSION expression, int line) {
    this.expression = expression;
    this.line = line;
  }

  @Override
  public void Check() {
    TYPE t = expression.getType();
    if (!t.isArrayType() && !t.isPairType()) {
      System.out.println("Line " + line + ": " + "Can only free arrays and pairs");
      System.exit(200);
    }
  }

}
