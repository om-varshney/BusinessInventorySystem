package Exceptions;

public class ProductUnavailableException extends Exception {
    private final String errorMessage;

    public ProductUnavailableException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
