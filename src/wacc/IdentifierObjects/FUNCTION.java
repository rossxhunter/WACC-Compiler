package wacc.IdentifierObjects;

import antlr.WACCParser;
import wacc.SymbolTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross on 02/11/2017.
 */
public class FUNCTION extends IDENTIFIER {

  private TYPE type;
  private PARAMLIST paramTypes;
  private SymbolTable symTab;

  public FUNCTION(TYPE t, PARAMLIST paramTypes) {
    type = t;
    if (paramTypes != null) {
      this.paramTypes = paramTypes;
    }
    else {
      List<WACCParser.ParamContext> params = new ArrayList<>();
      this.paramTypes = new PARAMLIST(params);
    }
  }

  public TYPE getType() {
    return type;
  }

  public int getNumParams() {
    return paramTypes.getNumParams();
  }

  public TYPE getParamType(int i) {
    return paramTypes.getParamType(i);
  }

  public void setSymTab(SymbolTable st) {
    symTab = st;
  }
}
