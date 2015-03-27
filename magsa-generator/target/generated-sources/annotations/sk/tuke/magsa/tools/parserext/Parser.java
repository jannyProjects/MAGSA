package sk.tuke.magsa.tools.parserext;

public class Parser {
  private static sk.tuke.magsa.tools.parserext.javacc.Parser _parser;

  public sk.tuke.magsa.tools.metamodel.Model parse(String input) throws ParseException {
    sk.tuke.magsa.tools.parserext.javacc.ParserTokenManager tm = new sk.tuke.magsa.tools.parserext.javacc.ParserTokenManager(input);
    if (_parser == null) {
      _parser = new sk.tuke.magsa.tools.parserext.javacc.Parser(tm);
    } else {
      _parser.ReInit(tm);
    }

    try {
      yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
      sk.tuke.magsa.tools.metamodel.Model root = sk.tuke.magsa.tools.parserext.javacc.Parser.parse();
      referenceResolver.resolveReferences();
      return root;
    } catch (sk.tuke.magsa.tools.parserext.javacc.ParseException e) {
      throw new ParseException("Problem parsing source code ", e);
    }
  }

  public sk.tuke.magsa.tools.metamodel.Model parse(java.io.Reader reader) throws ParseException {
    try {
      return parse(readAsString(reader));
    } catch(java.io.IOException e) {
      throw new ParseException("Problem reading input file", e);
    }
  }

  private String readAsString(java.io.Reader r) throws java.io.IOException {
    StringBuilder sb = new StringBuilder();
    java.io.BufferedReader br = new java.io.BufferedReader(r);
    String line;
    while ((line = br.readLine()) != null) {
      sb.append(line + "\n");
    }
    return sb.toString();
  }
}
