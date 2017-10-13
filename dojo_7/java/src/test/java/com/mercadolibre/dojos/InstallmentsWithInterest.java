package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 4/9/17.
 */
public class InstallmentsWithInterest extends Installments{

    private final double interest;

    public InstallmentsWithInterest(int qty, double interest) {
        super(qty);
        this.interest = interest;
    }

    public Amount splitAmount(Amount amount) {
        Amount splited = super.splitAmount(amount);
        return applyInterest(splited);
    }

    private Amount applyInterest(Amount splited) {
        return splited.multiply(1 + interest);
    }

}
