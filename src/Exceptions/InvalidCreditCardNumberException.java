package Exceptions;

public class InvalidCreditCardNumberException extends Exception {
    private final String errorMessage;

    public InvalidCreditCardNumberException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
