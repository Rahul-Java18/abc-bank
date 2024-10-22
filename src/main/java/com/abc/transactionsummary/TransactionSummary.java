package com.abc.transactionsummary;

import com.abc.TransactionDetail;
import com.abc.transactionsummary.*;
import java.util.ArrayList;
import java.util.List;


//To get transactions summary
public class TransactionSummary {
    private String accountType;
    private List<TransactionDetail> transactions;
    private String total;

    public TransactionSummary(String accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
        this.total = "$0.00"; // Initialize with default total
    }

    public String getAccountType() {
        return accountType;
    }

    public List<TransactionDetail> getTransactions() {
        return transactions;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void addTransaction(TransactionDetail transaction) {
        transactions.add(transaction);
    }
    @Override
    public String toString() {
        StringBuilder summary = new StringBuilder();
        summary.append(accountType).append(accountType).append("\n\n");

        // Add each transaction and the total
        for (TransactionDetail transaction : transactions) {
            summary.append("  ").append(transaction.getType())
                    .append(" ").append(transaction.getAmount()).append("\n");
        }
        summary.append("Total ").append(total).append("\n");

        return summary.toString();
    }
}
