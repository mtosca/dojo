package com.mercadolibre.dojos;

/**
 * Created by dsanchez on 11/10/17.
 */
public class NoneInconsitencia extends Inconsistency {

    public NoneInconsitencia(CheckoutOptions checkoutOptions) {
        super(checkoutOptions);
    }

    public Inconsistency challenge(Inconsistency otherInconsistency) {
        return otherInconsistency;
    }

    public Inconsistency happens() {
        return this;
    }

    @Override
    public int getNumber() {
        return IInconsistency.NONE;
    }

}
