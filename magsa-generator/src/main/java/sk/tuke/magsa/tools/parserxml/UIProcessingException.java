package sk.tuke.magsa.tools.parserxml;

public class UIProcessingException extends Exception {
    private static final long serialVersionUID = 1L;

    public UIProcessingException(String msg) {
        super(msg);
    }

    public UIProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
