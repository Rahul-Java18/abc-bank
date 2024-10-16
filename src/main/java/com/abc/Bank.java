package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Customer> customers;

    public Bank() {
       this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public String getFirstCustomer() {
        if(customers.isEmpty()){
            return null;
        }else{
            return customers.get(0).getName();
        }
    }

    public String customerSummary() {
        StringBuilder summary = new StringBuilder("Customer Summary");
        for (Customer customer : customers)
            summary.append("\n -").append(customer.getName()).append("(")
                .append(customer.getNumberOfAccounts()).append("accounts");
        return summary.toString();
    }


    public double totalInterestPaid() {
        return customers.stream().mapToDouble(customer::totalInterestEarned).sum();
    }

}

