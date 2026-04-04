package g145.g145market.exception;

public class PhoneNumberUniqueException extends RuntimeException {
    public PhoneNumberUniqueException() {
    }

    public PhoneNumberUniqueException(String message) {
        super(message);
    }
}
