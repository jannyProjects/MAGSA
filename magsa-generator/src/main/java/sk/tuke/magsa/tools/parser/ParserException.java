package sk.tuke.magsa.tools.parser;

public class ParserException extends Exception {
    private static final long serialVersionUID = 1L;

    public ParserException(String msg) {
        super(msg);
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
