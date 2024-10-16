package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private final String name;
    private final  List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }


    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        accouns.stream()
               .mapToDouble(Account::calculateIntrest).sum();
    }
    public void transferBetweenAccounts(Account fromAccount,Account toAccount,double amount){
        if(fromAccount.sumTransactions >= amount){
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }else{
            throw new IllegalArgumentException("Insuffient funds to transfer")
        }

    }

    public String getStatement() {
        StringBuilder statement = new StringBuilder("Statement for" + name +"\n");
    
        for(Account account :accounts){
            statement.append("\n").append(statementForAccount(account)).append("\n");
        }
        statement.append("\n Total In all accounts").append(String.format("$%,.2f",
        accounts.stream().mapToDouble(Account::sumTransactions).sum()));

        return statement.toString();
    }

    private String statementForAccount(Account account) {
        StringBuilder sb = new StringBuilder();

       sb.append(accountTypeToString(account.accountType())).append("\n");

       for(Transaction transaction :account.getTransactions()){
        sb.append(transaction.getAmount() < 0 ? "Withdrawl" : "deposit").
           append(String.format("%,.2f",Math.abs(transaction.getAmount()))).append("\n")
       }
       sb.append("Total $").append(String.format(%,.2f,account.sumTransactions()));

             return sb.toString();
    }

        private String accountTypeToString(AccountType accountType){
            switch(accountType){
                case CHECKING:
                    return "Checking account";
                   case SAVINGS:
                    return "Savings Account"; 
                    case MAXI_SAVINGS:
                    return "Maxi_savings account";
                   case SUPER_SAVINGS:
                    return "Super_Savings Account";
                    default:
                        return "Unknown Account Type"
            }
        }
}
