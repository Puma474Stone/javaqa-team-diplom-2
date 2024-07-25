package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditAccountTest {

    @Test
    public void testConstructorValidParameters() {
        CreditAccount account = new CreditAccount(1000, 500, 15);
        assertEquals(1000, account.getBalance());
        assertEquals(500, account.getCreditLimit());
        assertEquals(15, account.getRate());
    }

    @Test
    public void testConstructorNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1000, 500, 15);
        });
    }

    @Test
    public void testConstructorNegativeCreditLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1000, -500, 15);
        });
    }

    @Test
    public void testConstructorNegativeRate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1000, 500, -15);
        });
    }

    @Test
    public void testPayValidAmount() {
        CreditAccount account = new CreditAccount(1000, 500, 15);
        assertTrue(account.pay(500));
        assertEquals(500, account.getBalance());
    }

    @Test
    public void testPayExceedCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 500, 15);
        assertFalse(account.pay(2000));
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testPayNegativeAmount() {
        CreditAccount account = new CreditAccount(1000, 500, 15);
        assertFalse(account.pay(-500));
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testAddValidAmount() {
        CreditAccount account = new CreditAccount(1000, 500, 15);
        assertTrue(account.add(500));
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testAddNegativeAmount() {
        CreditAccount account = new CreditAccount(1000, 500, 15);
        assertFalse(account.add(-500));
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testYearChangePositiveBalance() {
        CreditAccount account = new CreditAccount(1000, 500, 15);
        assertEquals(0, account.yearChange());
    }

    @Test
    public void testYearChangeNegativeBalance() {
        CreditAccount account = new CreditAccount(-100, 500, 15);
        assertEquals(-15, account.yearChange());
    }
}

