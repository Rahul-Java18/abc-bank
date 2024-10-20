package com.abc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Bank bank = new Bank();

        Customer customer = new Customer("John Doe");
        bank.addCustomer(customer);
        //creating different types of accounts to customers
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Account maxiSavingsAccount = new Account(Account.MAXI_SAVINGS);
        Account superSavingsAccount = new Account(Account.SUPER_SAVINGS);

        //accounts for the customers
        customer.openAccount(checkingAccount);
        customer.openAccount(savingsAccount);
        customer.openAccount(maxiSavingsAccount);
        customer.openAccount(superSavingsAccount);

        // Transactions
        checkingAccount.deposit(1000);
        savingsAccount.deposit(2000);
        maxiSavingsAccount.deposit(3000);
        superSavingsAccount.deposit(4000);

        // Transfer from checking to savings
        customer.transfer(checkingAccount, savingsAccount, 500);

        // Output statements
       // System.out.println(customer.getStatement()); For normal statement print in string format
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonSummary = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(customer.getTransactionSummary());
        System.out.println(jsonSummary);

        System.out.println("Total Interest Paid by Bank: " + bank.totalInterestPaid());
        System.out.println("Total Interest Paid by savingsAccount: " + savingsAccount.interestEarned());
        System.out.println("Total Intrest paid by Maxi savingsAccount:" +maxiSavingsAccount.interestEarned());
        System.out.println("Total Interest Paid by supersavingsAccount: " + superSavingsAccount.interestEarned());

    }
}

