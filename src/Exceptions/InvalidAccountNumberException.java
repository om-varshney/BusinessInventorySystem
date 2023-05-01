package Exceptions;

public class InvalidAccountNumberException extends Exception {
    private final String errorMessage;

    public InvalidAccountNumberException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
