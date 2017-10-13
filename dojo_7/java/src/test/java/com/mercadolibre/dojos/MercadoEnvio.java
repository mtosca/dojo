package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 18/8/17.
 */
public class MercadoEnvio implements ShippingMethod {
    private final Amount cost;

    public MercadoEnvio(Amount shippingCost) {
        this.cost = shippingCost;
    }

    public Amount amount() {
        return cost;
    }
}
