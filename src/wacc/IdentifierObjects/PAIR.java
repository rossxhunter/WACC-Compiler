package wacc.IdentifierObjects;

import antlr.WACCParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross on 07/11/2017.
 */
public class PAIR extends VARIABLE {

  private TYPE t;
  private TYPE first;
  private TYPE second;

  public PAIR(TYPE t, TYPE first, TYPE second) {
    super(t);
    this.first = first;
    this.second = second;
  }

  public TYPE getFirst() {
    return first;
  }

  public TYPE getSecond() {
    return second;
  }

}
