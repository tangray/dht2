package bupt.fnl.dht.SelfDefinedException;

public class InputNullException extends RuntimeException {

    public InputNullException() {
        super();
    }

    public InputNullException(String msg) {
        super(msg);
    }

    public InputNullException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InputNullException(Throwable cause)
    {
        super(cause);
    }
}
