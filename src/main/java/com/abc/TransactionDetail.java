package com.abc;

// Transactions of individual account details
public class TransactionDetail {
    private String type;
    private String amount;

    public TransactionDetail(String type, String amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getAmount() {
        return amount;
    }
}

