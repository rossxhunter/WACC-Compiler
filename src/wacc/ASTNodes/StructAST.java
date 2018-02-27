package wacc.ASTNodes;

import antlr.WACCParser;
import wacc.IdentifierObjects.*;

import static wacc.Main.ST;

/**
 * Created by Ross on 05/12/2017.
 */
public class StructAST implements ASTNode {

  private WACCParser.IdentContext identContext;
  private WACCParser.FieldListContext fieldListContext;

  public StructAST(WACCParser.IdentContext identContext, WACCParser.FieldListContext fieldListContext) {
    this.identContext = identContext;
    this.fieldListContext = fieldListContext;
  }

  @Override
  public void Check() {
    STRUCT varObj = new STRUCT(identContext, fieldListContext);
    ST.add(varObj.getName(), varObj);
  }
}
