package wacc.ASTNodes;

import wacc.IdentifierObjects.EXPRESSION;
import wacc.IdentifierObjects.*;

import static wacc.Main.ST;

/**
 * Created by Ross on 07/12/2017.
 */
public class StructFieldAssignAST implements ASTNode {

  private STRUCT varObj;
  private String field;
  private EXPRESSION expr;

  public StructFieldAssignAST(String ident, String field, EXPRESSION expr) {
    this.varObj = (STRUCT) ST.lookupAll(ident);
    this.field = field;
    this.expr = expr;
  }

  @Override
  public void Check() {

  }
}
