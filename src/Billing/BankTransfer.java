package Billing;

import Interfaces.Billing;

public class BankTransfer implements Billing {
    private long accountNumber;
    private String IFSCCode;

    public BankTransfer(long accountNumber, String IFSCCode) {
        this.accountNumber = accountNumber;
        this.IFSCCode = IFSCCode;
    }
    @Override
    public double calculateShippingCost() {
        return 0;
    }

    @Override
    public double calculateTaxes() {
        return 0;
    }

    @Override
    public double payableAmount() {
        return 0;
    }
}
