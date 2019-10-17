package bupt.fnl.dht.SelfDefinedException;

public class QueryNotExistException extends RuntimeException {
    public QueryNotExistException() {
        super();
    }

    public QueryNotExistException(String msg) {
        super(msg);
    }

    public QueryNotExistException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public QueryNotExistException(Throwable cause)
    {
        super(cause);
    }
}
