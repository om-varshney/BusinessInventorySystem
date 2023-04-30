package Exceptions;

public class InvalidAccountNumber extends Exception {
    private final String errorMessage;

    public InvalidAccountNumber(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
