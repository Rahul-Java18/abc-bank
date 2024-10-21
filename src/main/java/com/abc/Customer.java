package com.abc;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Method to open a new account for the customer
    public Customer openAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    // Method to calculate the total interest earned across all accounts
    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts) {
            total += a.interestEarned();
        }
        return total;
    }

    // Method to generate a statement detailing all accounts and transactions
    public String getStatement() {
        String statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.sumTransactions(); // Sum the total transactions for all accounts
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }
    private String statementForAccount(Account account) {
        StringBuilder s = new StringBuilder();

        // Translate to pretty account type
        switch (account.getAccountType()) {
            case Account.CHECKING:
                s.append("Checking Account\n");
                break;
            case Account.SAVINGS:
                s.append("Savings Account\n");
                break;
            case Account.MAXI_SAVINGS:
                s.append("Maxi Savings Account\n");
                break;
            case Account.SUPER_SAVINGS:
                s.append("Super Savings Account\n");
                break;
            default:
                s.append("Unknown Account Type\n");
        }

        // Now total up all the transactions
        double total = 0.0;
        for (Transaction t : account.transactions) {
            String type = (t.amount < 0) ? "withdrawal" : "deposit";
            s.append("  ").append(type).append(" ").append(toDollars(t.amount)).append("\n");
            total += t.amount;
        }
        s.append("Total ").append(toDollars(total));
        return s.toString();
    }


    public List<TransactionSummary> getTransactionSummary() {
        List<TransactionSummary> summaries = new ArrayList<>();
        for (Account a : accounts) {
            TransactionSummary summary = new TransactionSummary(accountTypeName(a));
            double total = 0.0;

            for (Transaction t : a.transactions) {
                String type = (t.amount < 0) ? "withdrawal" : "deposit";
                String amount = toDollars(t.amount);
                summary.addTransaction(new TransactionDetail(type, amount));
                total += t.amount;
            }
            summary.setTotal(toDollars(total));
            summaries.add(summary);
        }
        return summaries;
    }

    private String accountTypeName(Account account) {
        switch (account.getAccountType()) {
            case Account.CHECKING:
                return "Checking Account";
            case Account.SAVINGS:
                return "Savings Account";
            case Account.MAXI_SAVINGS:
                return "Maxi Savings Account";
            case Account.SUPER_SAVINGS:
                return "Super Savings Account";
            default:
                return "Unknown Account Type";
        }
    }

    // For dollar format
    private String toDollars(double d) {
        return String.format("$%,.2f", abs(d));
    }

    // New transfer method to transfer funds between accounts
    public void transfer(Account fromAccount, Account toAccount, double amount) {
        // Checking for null accounts
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        // Withdraw and deposit
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
