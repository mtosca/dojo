package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 18/8/17.
 */
public class Amount {
    private float amount;

    public Amount(float amount) {
        this.amount = amount;
    }

    public Amount() {
        this.amount = 0;
    }

    public String print() {
        return String.format("$ %.0f", amount);
    }

    public Amount split(int qty) {
        return new Amount(amount / qty);
    }

    public Amount plus(Amount amount) {
        this.amount += amount.amount;
        return this;
    }

    public Amount substract(Amount amount) {
        if(this.amount > amount.amount) {
            this.amount -= amount.amount;
        } else {
            this.amount = 0;
        }
        return this;
    }

    public Amount min(Amount remainingAmount) {
        return new Amount(Math.min(this.amount, remainingAmount.amount));
    }

    public Amount multiply(double factor) {
        this.amount *= factor;
        return this;
    }
}
