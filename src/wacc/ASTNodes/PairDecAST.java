package wacc.ASTNodes;

import wacc.IdentifierObjects.PAIR;
import wacc.IdentifierObjects.TYPE;
import wacc.IdentifierObjects.VARIABLE;

import static wacc.Main.ST;

public class PairDecAST implements ASTNode {

  private String typename;
  private String firstType;
  private String secondType;
  private String varname;

  public PairDecAST(String typename, String firstType, String secondType, String varname) {
    this.typename = typename;
    this.firstType = firstType;
    this.secondType = secondType;
    this.varname = varname;
  }

  @Override
  public void Check() {
    TYPE T = (TYPE) ST.lookupAll(typename);
    TYPE T1 = (TYPE) ST.lookupAll(firstType);
    TYPE T2 = (TYPE) ST.lookupAll(secondType);
    VARIABLE V = (VARIABLE) ST.lookup(varname);

    if (T == null || T1 == null || T2 == null) {
      System.exit(200);
    } else if (!(T instanceof TYPE) || !(T1 instanceof TYPE) || !(T2 instanceof TYPE)) {
      System.exit(200);
    } else if (!(T.isDeclarable()) || !(T1.isDeclarable()) || !(T2.isDeclarable())) {
      System.exit(200);
    } else if (V != null) {
      System.exit(200);
    } else {
      PAIR varObj = new PAIR(T, T1, T2);
      ST.add(varname, varObj);
    }

  }

}
