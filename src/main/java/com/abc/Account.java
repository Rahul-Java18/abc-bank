package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Account {

   

    private final AccountType accountType;
    public final List<Transaction> transactions;

    public Account(AccountType accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit Amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

public void withdraw(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
    } else {
        transactions.add(new Transaction(-amount));
    }
}

    public double CalculateIntrest() {
        double amount = sumTransactions();
        switch(accountType){
            case CHECKING:
                return amount * 0.001;
            case SAVINGS:
               return amount <= 1000 ? amount * 0.001 + (amount - 1000) *0.002;

               case MAXI_SAVINGS:
                if (amount <= 1000)
                    return amount * 0.02;
                else if (amount <= 2000)
                    return 1000 * 0.02 +(amount - 1000) * 0.05;
                    else{
                     return 1000 * 0.02 + 1000 *0.05 +(amount - 2000)*0.01;
                    }
                

//            case SUPER_SAVINGS:
//                calculateSuperSavingsIntrest(amount);
//   
               default:
                throw new IllegalArgumentException("Unknown account type");
        }
    }

        private double calculateSuperSavingsIntrest(double amount){
            return amount <= 1000 ? amount * 0.04:1000 * 0.04+(amount - 1000) * 0.07;
        }
    public double sumTransactions() {
       return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

   public List<Transaction> getTransactions(){
    return transactions;
   }

}
