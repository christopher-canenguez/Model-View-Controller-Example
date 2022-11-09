package models;

import javafx.beans.property.*;

public class AccountDetails {

    private final StringProperty accountHolder;
    private final IntegerProperty accountNumber;
    private final DoubleProperty accountBalance;

    public AccountDetails(String accountHolder, Integer accountNumber, Double accountBalance) {
        this.accountHolder = new SimpleStringProperty(accountHolder);
        this.accountNumber = new SimpleIntegerProperty(accountNumber);
        this.accountBalance = new SimpleDoubleProperty(accountBalance);
    } // End AccountDetails.

    public String getAccountHolder() {
        return accountHolder.get();
    } // End getAccountHolder.

    public StringProperty accountHolderProperty() {
        return accountHolder;
    } // End accountHolderProperty.

    public int getAccountNumber() {
        return accountNumber.get();
    } // End getAccountNumber.

    public IntegerProperty accountNumberProperty() {
        return accountNumber;
    } // End accountNumberProperty.

    public double getAccountBalance() {
        return accountBalance.get();
    } // End getAccountBalance.

    public DoubleProperty accountBalanceProperty() {
        return accountBalance;
    } // End accountBalanceProperty.

    public void deposit(double amount) {
        accountBalance.set(accountBalance.get() + amount);
    } // End deposit.

    public void withdraw(double amount) {
        accountBalance.set(accountBalance.get() - amount);
    } // End withdraw.
} // End AccountDetails.
