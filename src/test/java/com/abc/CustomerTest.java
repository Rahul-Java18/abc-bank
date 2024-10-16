package com.abc;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test 
    public void testTransferBetweenAccounts(){
        Customer customers = new Customer("jane");
        Account checkingAccount = new Account(AccountType.CHECKING);
        Account savingsAccount = new Account(AccountType.SAVINGS);

        customer.openAccount(checkingAccount);
        customer.openAccount(savingsAccount);
        checkingAccount.deposit(500.0);

        customer.transferBetweenAccounts(checkingAccount,savingsAccount,200.0);
        assertEquals(300.0,checkingAccount.sumTransactions(),0);
        assertEquals(200.0,savingsAccount.sumTransactions(),0);



       
}
