package wacc.IdentifierObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TYPE extends IDENTIFIER {

  private String type;

  public TYPE(String t) {
    type = t;
  }

  public String getType() {
    return type;
  }

  public boolean isReturnable() {
    return true;
  }

  public boolean isDeclarable() {
    return true;
  }

  public boolean isArrayType() {
    String t = this.type;
    String pattern = ".*\\[\\]";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(t);
    return m.find();
  }

  public boolean isPairType() {
    String t = this.type;
    String pattern = "pair.*";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(t);
    return m.find();
  }
}
