package bupt.fnl.dht.SelfDefinedException;

public class DoubleInsertException extends RuntimeException {
    public DoubleInsertException() {
        super();
    }

    public DoubleInsertException(String msg) {
        super(msg);
    }

    public DoubleInsertException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DoubleInsertException(Throwable cause)
    {
        super(cause);
    }
}
