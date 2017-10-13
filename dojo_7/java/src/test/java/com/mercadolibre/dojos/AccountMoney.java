package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 18/8/17.
 */
public class AccountMoney implements PaymentMethod {

    private final Amount balance;

    public AccountMoney(Amount balance) {
        this.balance = balance;
    }

    public String printDetail(Amount amount) {
        return "Dinero en Cuenta: " + amount.print();
    }

    public Amount contributes(Amount remainingAmount) {
        return balance.min(remainingAmount);
    }

    @Override
    public boolean hasLimitedBalance() {
        return true;
    }
}
