package wacc.IdentifierObjects;

import antlr.WACCParser;

import java.util.ArrayList;
import java.util.List;

public class PARAM extends IDENTIFIER {

  private TYPE type;

  public PARAM(antlr.WACCParser.ParamContext p) {
    type = new TYPE(p.type().getText());
  }

  public PARAM(antlr.WACCParser.ExprContext e) {
    List<WACCParser.ExprContext> exprList = new ArrayList<>();
    exprList.add(e);
    EXPRESSION expr = new EXPRESSION(exprList);
    type = expr.getType();
  }

  public TYPE getType() {
    return type;
  }

}
