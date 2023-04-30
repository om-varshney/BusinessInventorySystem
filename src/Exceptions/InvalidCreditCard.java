package Exceptions;

public class InvalidCreditCard extends Exception {
    private final String errorMessage;

    public InvalidCreditCard(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
