package Exceptions;

public class ProductUnavailable extends Exception {
    private final String errorMessage;

    public ProductUnavailable(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
