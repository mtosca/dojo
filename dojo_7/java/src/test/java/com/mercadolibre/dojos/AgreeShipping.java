package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 1/9/17.
 */
public class AgreeShipping implements ShippingMethod {
    public Amount amount() {
        return new Amount();
    }
}
