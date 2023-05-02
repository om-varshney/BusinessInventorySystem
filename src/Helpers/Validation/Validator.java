package Helpers.Validation;

import Exceptions.InvalidAccountNumberException;
import Exceptions.InvalidIFSCCodeException;
import Exceptions.InvalidCreditCardNumberException;
import org.jetbrains.annotations.NotNull;

public class Validator {

    // Account number validation method
    public static void validateAccountNumber(@NotNull String accountNumber) throws InvalidAccountNumberException {
        // Check for valid account number format (12 digits)
        if (!accountNumber.matches("\\d{12}")) {
            throw new InvalidAccountNumberException("Invalid account number format! Must be 12 digits.");
        }
    }

    // IFSC code validation method
    public static void validateIFSCCode(@NotNull String ifscCode) throws InvalidIFSCCodeException {
        // Check for valid IFSC code format (11 characters)
        if (!ifscCode.matches("[A-Z]{4}\\d{7}")) {
            throw new InvalidIFSCCodeException("Invalid IFSC code format! Must be 11 characters in the format ABCD0123456.");
        }
    }

    // Credit card number validation method
    public static void validateCreditCardNumber(@NotNull String creditCardNumber) throws InvalidCreditCardNumberException {
        // Check for valid credit card number format (16 digits)
        if (!creditCardNumber.matches("\\d{16}")) {
            throw new InvalidCreditCardNumberException("Invalid credit card number format! Must be 16 digits.");
        }
    }

}

