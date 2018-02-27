package wacc.ASTNodes;


import wacc.IdentifierObjects.*;

import java.util.List;

import static wacc.Main.ST;

public class PairElemAssignAST implements ASTNode {

  TYPE type = null;
  EXPRESSION expr;
  VARIABLE varObj;
  boolean isFirst;

  public PairElemAssignAST(String ident, EXPRESSION expr, boolean isFirst) {
    this.isFirst = isFirst;
    IDENTIFIER identVar = ST.lookupAll(ident);

    if (identVar == null) {
      System.exit(200);
    } else if (!(identVar instanceof VARIABLE)) {
      System.exit(200);
    }

    VARIABLE overallType = ((VARIABLE) identVar);

    if (isFirst) {
      this.type = ((PAIR) overallType).getFirst();
    } else {
      this.type = ((PAIR) overallType).getSecond();
    }

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
        System.exit(200);
      }
    }
  }
}
