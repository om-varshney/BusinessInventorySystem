package Exceptions;

public class InvalidIFSCCodeException extends Exception {
    private final String errorMessage;

    public InvalidIFSCCodeException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
