package Exceptions;

public class UnauthenticatedUser extends Exception {
    private final String errorMessage;

    public UnauthenticatedUser(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
