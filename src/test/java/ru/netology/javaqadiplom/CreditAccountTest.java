package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void replenishmentOfThePositiveBalance_1() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        account.add(3_000);

        int expected = 4_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void replenishmentOfThePositiveBalance_2() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        boolean expected = true;
        boolean actual = account.add(3_000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void replenishmentOfTheBalanceByNegativeAmount_1() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        account.add(-3_000);

        int expected = 1_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void replenishmentOfTheBalanceByNegativeAmount_2() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        boolean expected = false;
        boolean actual = account.add(-3_000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void replenishmentOfTheBalanceByZero_1() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        account.add(0);

        int expected = 1_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void replenishmentOfTheBalanceByZero_2() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        boolean expected = false;
        boolean actual = account.add(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceBalanceByPurchaseAmountWithoutExceedingCreditLimit_1() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );
        account.pay(3_000);

        int expected = -2_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceBalanceByPurchaseAmountWithoutExceedingCreditLimit_2() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        boolean expected = true;
        boolean actual = account.pay(3_000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceBalanceByPurchaseAmountByExceedingCreditLimit_1() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );
        account.pay(6_001);

        int expected = 1_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceBalanceByPurchaseAmountByExceedingCreditLimit_2() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        boolean expected = false;
        boolean actual = account.pay(6_001);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceBalanceByPurchaseAmountEqualToZero_1() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        account.pay(0);

        int expected = 1_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceBalanceByPurchaseAmountEqualToZero_2() {
        CreditAccount account = new CreditAccount(
                1_000, // начальный баланс
                5_000, //кредитный лимит
                15 // Ставка
        );

        boolean expected = false;
        boolean actual = account.pay(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void chargeInterestOnNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,  // начальный баланс
                5000, //кредитный лимит
                15 // Ставка
        );
        account.pay(200);
        int expected = -30;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void chargeInterestOnBalanceEqualToZero() {
        CreditAccount account = new CreditAccount(
                0,  // начальный баланс
                5000, //кредитный лимит
                15 // Ставка
        );

        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addInterestToThePositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,  // начальный баланс
                5000, //кредитный лимит
                15 // Ставка
        );

        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void CreateAnObjectWithNegativeCreditRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    200, // начальный баланс
                    5_000, //кредитный лимит
                    -15 // Ставка
            );
        });
    }

    @Test
    public void createAnObjectWithNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -200, // начальный баланс
                    5_000, //кредитный лимит
                    15 // Ставка
            );
        });
    }

    @Test
    public void createAnObjectWithNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    200, // начальный баланс
                    -5_000, //кредитный лимит
                    15 // Ставка
            );
        });
    }
}
