package wacc.IdentifierObjects;

/**
 * Created by Ross on 02/11/2017.
 */
public class VARIABLE<T> extends IDENTIFIER {

  private TYPE type;
  private T value;

  public VARIABLE(TYPE t) {
    type = t;
  }
  
  public TYPE getType() {
    return type;
  }
  
}
