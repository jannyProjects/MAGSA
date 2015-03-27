package sk.tuke.magsa.tools.builder;

public class ConstraintProcessingException extends Exception {
    private static final long serialVersionUID = 1L;

    public ConstraintProcessingException(String msg) {
        super(msg);
    }

    public ConstraintProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
