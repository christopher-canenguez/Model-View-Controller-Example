package com.mycompany.javafx_mvc_example.controller;

import com.mycompany.javafx_mvc_example.view.AppView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import models.AccountDetails;

public class AppController {

    //Model
    AccountDetails account;

    public AppController(AppView view) {
        setView(view);
    } // End AppController.

    public void setView(AppView view) {
        //get model
        account = new AccountDetails("Moaath Alrajab", 987634, 100d);

        //link Model with View
        view.getAccountHolderDetailsLabel().textProperty().bind(account.accountHolderProperty());
        view.getAccountBalanceDetailsLabel().textProperty().bind(account.accountBalanceProperty().asString());
        view.getAccountNumberDetailsLabel().textProperty().bind(account.accountNumberProperty().asString());

        //link Controller to View - ensure only numeric input (integers) in text field
        view.getAmountTextField().setTextFormatter(new TextFormatter<>(change -> {
            if (change.getText().matches("\\d+") || change.getText().equals("")) {
                return change;
            } else {
                change.setText("");
                change.setRange(
                        change.getRangeStart(),
                        change.getRangeStart()
                );
                return change;
            } // End else.
        }));

        //link Controller to View - methods for buttons
        view.getDepositButton().setOnAction(event -> {
            account.deposit(getAmount(view.getAmountTextField()));
            event.consume();
        });
        view.getWithdrawalButton().setOnAction(event -> {
            account.withdraw(getAmount(view.getAmountTextField()));
            event.consume();
        });
    }

    private double getAmount(TextField field) {
        if (field.getText().equals("")) {
            return 0;
        } // End if.

        return Double.parseDouble(field.getText());
    } // End getAmount.
} // End AppController.
