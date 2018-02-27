package wacc.ASTNodes;

import antlr.WACCParser;
import wacc.IdentifierObjects.ARRAY;
import wacc.IdentifierObjects.TYPE;
import wacc.IdentifierObjects.VARIABLE;

import static wacc.Main.ST;

/**
 * Created by Ross on 07/11/2017.
 */
public class ArrayDecAST<T> implements ASTNode{
  private String typename;
  private String varname;
  private WACCParser.ArrayLitContext arrayLitContext;
  private int line;

  public ArrayDecAST(String typename, String varname, WACCParser.ArrayLitContext arrayLitContext, int line) {
    this.typename = typename;
    this.varname = varname;
    this.arrayLitContext = arrayLitContext;
    this.line = line;
  }

  @Override
  public void Check() {
    TYPE T = (TYPE) ST.lookupAll(typename);
    VARIABLE V = (VARIABLE) ST.lookup(varname);
    if (T == null) {
      System.exit(200);
    }
    else if (!(T instanceof TYPE)) {
      System.exit(200);
    }
    else if (!(T.isDeclarable())) {
      System.exit(200);
    }
    else if (V != null) {
      System.out.println("Line " + line + ": " + "Variable already declared in the same scope");
      System.exit(200);
    }
    else {
      ARRAY varObj = new ARRAY(T, arrayLitContext);
      ST.add(varname, varObj);
    }
  }
}
