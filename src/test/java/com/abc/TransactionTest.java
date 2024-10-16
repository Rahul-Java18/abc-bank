package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TransactionTest {
    @Test
    public void transaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
    }
    @Test
    public void testTransactionCreation() {
        Transaction transaction = new Transaction(100.0);
        assertEquals(100.0,transaction.getAmount(),0.0);
    }
    @Test
    public void testTransactionDate() {
        Transaction transaction = new Transaction(200.0);
        assertNotNull(transaction.getTransactionDate());
    }
}
