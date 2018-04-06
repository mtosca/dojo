package com.mercadolibre.dojos;

/**
 * Created by dsanchez on 11/10/17.
 */
public class AgreeAgree extends Inconsistency {

    public AgreeAgree(CheckoutOptions checkoutOptions) {
        super(checkoutOptions);

    }

    public Inconsistency challenge(Inconsistency otherInconsistency) {
        return this;
    }

    public Inconsistency happens() {
        if ( getCheckoutOptions().isAgreeAgree() ) {
            return this;
        }

        return new NoneInconsitencia( getCheckoutOptions() );
    }

    public int getNumber() {
        return IInconsistency.AGREE_AGREE;
    }
}
