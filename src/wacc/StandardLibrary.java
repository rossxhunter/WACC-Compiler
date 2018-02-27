package wacc;

/**
 * Created by Ross on 05/12/2017.
 */

import antlr.WACCLexer;
import antlr.WACCParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

public class StandardLibrary {

  private ParseTree tree;

  private static StandardLibrary instance = new StandardLibrary();

  private StandardLibrary() {
    File file = new File("src/wacc/stdlib.wacc");
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ANTLRInputStream input = null;
    try {
      input = new ANTLRInputStream(fis);
    } catch (IOException e) {
      e.printStackTrace();
    }
    WACCLexer lexer = new WACCLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    WACCParser parser = new WACCParser(tokens);
    ParseTree tree = parser.program();
    this.tree = tree;
  }

  public static StandardLibrary getInstance() {
    return instance;
  }

  public void visit(MainVisitor visitor) {
    visitor.visit(tree);
  }
}
