package com.abc;

import java.util.Date;

public class Transaction {
    public final double amount;

    private final Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = new Date();
    }
    public double getAmount(){
        return amount;
    }
    public Date getTransactionDate(){
        return transactionDate;
    }

}
