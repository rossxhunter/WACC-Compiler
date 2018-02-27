package wacc.IdentifierObjects;

import antlr.WACCParser;

/**
 * Created by Ross on 05/12/2017.
 */
public class FIELD {
  private TYPE type;
  private String name;

  public FIELD(WACCParser.ParamContext paramContext) {
    type = new TYPE(paramContext.type().getText());
    name = paramContext.ident().getText();
  }
}
