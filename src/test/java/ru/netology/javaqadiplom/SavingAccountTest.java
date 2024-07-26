package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    private SavingAccount savingAccount;

    @BeforeEach
    public void setUp() {
        savingAccount = new SavingAccount(10_000, 1_000, 15_000, 10);
    }

    @Test
    public void exceptionsForInvalidInputData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAccount = new SavingAccount(10_000, 20_000, 15_000, 10);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAccount = new SavingAccount(10_000, -5, 15_000, 10);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAccount = new SavingAccount(-5, 1_000, 15_000, 10);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAccount = new SavingAccount(900, 1_000, 15_000, 10);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAccount = new SavingAccount(10_000, 1_000, 15_000, -5);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAccount = new SavingAccount(17_000, 1_000, 15_000, -5);
        });
    }

    @Test
    public void paymentsWithBalanceCheck() {
        Assertions.assertFalse(savingAccount.pay(-4));
        Assertions.assertFalse(savingAccount.pay(9_500));
        Assertions.assertTrue(savingAccount.pay(5_000));
    }

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void replenishmentWithBalanceCheck() {
        Assertions.assertFalse(savingAccount.add(-4));
        Assertions.assertFalse(savingAccount.add(6_000));
    }

    @Test
    public void calculationOfInterestOnBalance() {
        savingAccount = new SavingAccount(225, 100, 15_000, 10);
        Assertions.assertEquals(22, savingAccount.yearChange());
    }

}
