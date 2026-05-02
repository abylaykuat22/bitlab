package g145.g145market.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }
}
