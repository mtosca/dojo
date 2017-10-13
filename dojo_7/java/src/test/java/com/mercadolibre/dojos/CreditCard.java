package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 18/8/17.
 */
public class CreditCard implements PaymentMethod {
    private final Installments installments;

    public CreditCard(Installments installments) {
        this.installments = installments;
    }

    public CreditCard() {
        this.installments = new Installments(1);
    }

    private Amount contribution(Amount totalOrderAmount) {
        return installments.splitAmount(contributes(totalOrderAmount));
    }

    public String printDetail(Amount orderAmount) {
        Amount contribution = contribution(orderAmount);
        return "Tarjeta de Credito " + installments.printQuantity() + contribution.print();
    }

    public Amount contributes(Amount remainingAmount) {
        return remainingAmount.min(remainingAmount);
    }

    @Override
    public boolean hasLimitedBalance() {
        return false;
    }
}
