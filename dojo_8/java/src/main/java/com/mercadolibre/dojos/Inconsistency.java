package com.mercadolibre.dojos;

public abstract class Inconsistency {

    private final CheckoutOptions checkoutOptions;

    public abstract Inconsistency happens();

    @IInconsistency
    public abstract int getNumber();

    Inconsistency(CheckoutOptions checkoutOptions) {
        this.checkoutOptions = checkoutOptions;
    }

    public boolean equals(Object other) {
        Inconsistency another = (Inconsistency)other;

        return another.getNumber() == this.getNumber();
    }

    protected final CheckoutOptions getCheckoutOptions() {
        return this.checkoutOptions;
    }

    public abstract Inconsistency challenge(Inconsistency otherInconsistency);
}
