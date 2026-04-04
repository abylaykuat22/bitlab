package g145.g145market.exception;

public class EmailUniqueException extends RuntimeException {
    public EmailUniqueException() {
    }

    public EmailUniqueException(String message) {
        super(message);
    }
}
