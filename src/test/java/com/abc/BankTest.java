package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void testGetFirstCustomer() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        bank.addCustomer(john);
        assertEquals("John"bank.getFirstCustomer());
    }
     @Test
    public void testGetFirstCustomerNoCustomers() {
        Bank bank = new Bank();
        assertNull(bank.getFirstCustomer());
    }

    

    
    

}
