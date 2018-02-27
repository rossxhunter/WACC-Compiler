package wacc.IdentifierObjects;

import java.util.ArrayList;
import java.util.List;

public class PARAMLIST extends IDENTIFIER {

  private List<PARAM> list = new ArrayList<>();
  private List<String> idents = new ArrayList<>();

  public PARAMLIST(List<antlr.WACCParser.ParamContext> paramContextList) {
    for (antlr.WACCParser.ParamContext p : paramContextList) {
      list.add(new PARAM(p));
      idents.add(p.ident().getText());
    }
  }

  public PARAMLIST(antlr.WACCParser.ArgListContext argListContext) {
    List<antlr.WACCParser.ExprContext> args = argListContext.expr();
    for (antlr.WACCParser.ExprContext arg : args) {
      EXPRESSION e = new EXPRESSION(arg.expr());
      list.add(new PARAM(arg));
    }
  }

  public int getNumParams() {
    return list.size();
  }

  public TYPE getParamType(int i) {
    return list.get(i).getType();
  }

  public String getParamIdent(int i) {
    return idents.get(i);
  }
}
