package com.mercadolibre.dojos;

/**
 * Created by dsanchez on 11/10/17.
 */
public class CantSentXunits extends Inconsistency {
    CheckoutOptions checkoutOptions;

    public CantSentXunits(CheckoutOptions checkoutOptions) {
        super(checkoutOptions);
    }

    public Inconsistency challenge(Inconsistency otherInconsistency) {
        return this;
    }

    public Inconsistency happens() {
        if ( getCheckoutOptions().itemCantSendUnitsAndHasLocalPickup() ) {
            return this;
        }

        return new NoneInconsitencia( getCheckoutOptions() );
    }

    public int getNumber() {
        return IInconsistency.CANT_SENT_X_UNITS;
    }
}

