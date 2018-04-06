package com.mercadolibre.dojos;

/**
 * Created by dsanchez on 11/10/17.
 */
public class OnlyToAgree extends Inconsistency {
    public OnlyToAgree(CheckoutOptions checkoutOptions) {
        super(checkoutOptions);
    }

    public Inconsistency challenge(Inconsistency otherInconsistency) {
        return this;
    }

    public Inconsistency happens() {
        if ( getCheckoutOptions().isShippingToAgreeOnly() ) {
            return this;
        }

        return new NoneInconsitencia( getCheckoutOptions() );
    }

    public int getNumber() {
        return IInconsistency.ONLY_TO_AGREE;
    };
}
