package wacc.ASTNodes;

import wacc.IdentifierObjects.*;

import static wacc.Main.ST;

/**
 * Created by Ross on 07/11/2017.
 */
public class CallAST implements ASTNode {

  private String type;
  private String funcName;
  private PARAMLIST params;
  private int line;

  public CallAST(String type, String funcName, PARAMLIST params, int line) {
    this.type = type;
    this.funcName = funcName;
    this.params = params;
    this.line = line;
  }

  @Override
  public void Check() {
    FUNCTION f = (FUNCTION) ST.lookupAll(funcName);
    if (f == null) {
      System.out.println("Line " + line + ": " + "Function not defined");
      System.exit(200);
    }
    int numFuncParams = f.getNumParams();
    int numCallParams = params.getNumParams();
    if (numCallParams != numFuncParams) {
      System.out.println("Line " + line + ": " + "Incorrect number of parameters");
      System.exit(200);
    }
    for (int i = 0; i < numCallParams; i++) {
      if (f.getParamType(i).getType().compareTo(params.getParamType(i).getType()) != 0) {
        System.out.println("Line " + line + ": " + "Parameter " + (i + 1) + " is of invalid type");
        System.exit(200);
      }
    }
    if (f.getType().getType().compareTo(type) != 0) {
      System.out.println("Line " + line + ": " + "Function return type does not match call");
      System.exit(200);
    }
  }

}
