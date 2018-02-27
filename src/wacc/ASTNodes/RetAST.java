package wacc.ASTNodes;

import wacc.IdentifierObjects.EXPRESSION;
import wacc.IdentifierObjects.FUNCTION;
import wacc.IdentifierObjects.TYPE;

import java.util.List;

import static wacc.Main.ST;

/**
 * Created by Ross on 07/11/2017.
 */
public class RetAST implements ASTNode {

  private EXPRESSION expr;
  private FUNCTION func;
  private int line;

  public RetAST(FUNCTION func, EXPRESSION expr, int line) {
    this.expr = expr;
    this.func = func;
    this.line = line;
  }

  @Override
  public void Check() {
    if (ST.getEncSymTable() == null) {
      System.out.println("Line " + line + ": " + "Cannot return from main program");
      System.exit(200);
    }
    TYPE retType = func.getType();
    List<TYPE> subExpressionTypes = expr.getSubExpressionTypes();
    for (TYPE t : subExpressionTypes) {
      if (t.getType().compareTo(retType.getType()) != 0 && !retType.getType().equals("bool")) {
        System.out.println("Line " + line + ": " + "Incompatible types");
        System.out.println(t.getType());
        System.out.println(retType.getType());
        System.exit(200);
      }
    }
  }
}
