package wacc.IdentifierObjects;

import antlr.WACCParser;

import java.util.ArrayList;

/**
 * Created by Ross on 07/12/2017.
 */
public class STRUCT extends IDENTIFIER {

  private String name;
  private ArrayList<FIELD> fields;

  public STRUCT(WACCParser.IdentContext identContext, WACCParser.FieldListContext fieldListContext) {
    name = identContext.getText();
    fields = getFieldsFromListContext(fieldListContext);
  }

  private ArrayList<FIELD> getFieldsFromListContext(WACCParser.FieldListContext fieldListContext) {
    ArrayList<FIELD> fieldList = new ArrayList<>();
    int i = 0;
    while (fieldListContext.param(i) != null) {
      FIELD newField = new FIELD(fieldListContext.param(i));
      fieldList.add(newField);
    }
    return fieldList;
  }

  public String getName() {
    return name;
  }

}
