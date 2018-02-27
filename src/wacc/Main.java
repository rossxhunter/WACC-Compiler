package wacc;

// import ANTLR's runtime libraries

import antlr.WACCLexer;
import antlr.WACCParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import wacc.IdentifierObjects.TYPE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.List;
import java.util.regex.Pattern;

// import antlr package (your code)

public class Main {

  public static SymbolTable ST = new SymbolTable(null);
  public static MachineCode MC = MachineCode.getInstance();

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);

    FileInputStream fis = new FileInputStream(file);
    // create a CharStream that reads from standard input
    ANTLRInputStream input = new ANTLRInputStream(fis);

    // create a lexer that feeds off of input CharStream
    WACCLexer lexer = new WACCLexer(input);

    // create a buffer of tokens pulled from the lexer
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // create a parser that feeds off the tokens buffer
    WACCParser parser = new WACCParser(tokens);

    ParseTree tree = parser.program(); // begin parsing at program rule
    int numSyntaxErrors = parser.getNumberOfSyntaxErrors();
    //System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    if (numSyntaxErrors > 0) {
      System.exit(100);
    }
    ST.add("int", new TYPE("int"));
    ST.add("char", new TYPE("char"));
    ST.add("bool", new TYPE("bool"));
    ST.add("string", new TYPE("string"));
    ST.add("int[]", new TYPE("int[]"));
    ST.add("char[]", new TYPE("char[]"));
    ST.add("bool[]", new TYPE("bool[]"));
    ST.add("string[]", new TYPE("string[]"));
    ST.add("pair", new TYPE("pair"));

    List<String> s = ST.getAll();

    for (String s1 : s ) {
      for(String s2 : s) {
        ST.add("pair(" + s1 + "," + s2 + ")", new TYPE("pair(" + s1 + "," + s2 + ")"));
      }
    }

    System.out.println("====");
    MainVisitor visitor = new MainVisitor();
    StandardLibrary standardLibrary = StandardLibrary.getInstance();
    standardLibrary.visit(visitor);
    visitor.visit(tree);
    System.out.println("====");
    //System.out.println(MC.getLines());

    String[] splitPath = args[0].split("/");
    String[] splitExt = splitPath[splitPath.length - 1].split(Pattern.quote("."));
    String outputFilename = splitExt[0];
    File output = new File(outputFilename + ".s");
    output.createNewFile();

    FileWriter writer = new FileWriter(output);
    writer.write(MC.getLines());
    writer.close();

    System.exit(0);
  }
}
