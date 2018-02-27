package wacc.IdentifierObjects;

import antlr.WACCParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross on 07/11/2017.
 */
public class ARRAY extends VARIABLE {

  private int length;
  private List<EXPRESSION> items = new ArrayList<>();

  public ARRAY(TYPE t, WACCParser.ArrayLitContext arrayLitContext) {
    super(t);
    List<WACCParser.ExprContext> exprs = arrayLitContext.expr();
    this.length = exprs.size();
    for (WACCParser.ExprContext expr : exprs) {
      items.add(new EXPRESSION(expr.expr()));
    }
  }

  public int getLength() {
    return length;
  }
}
