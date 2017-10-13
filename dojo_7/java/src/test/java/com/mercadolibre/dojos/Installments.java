package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 18/8/17.
 */
public class Installments {
    private final int qty;

    public Installments(int qty) {
        this.qty = qty;
    }

    public Amount splitAmount(Amount amount) {
        return amount.split(qty);
    }

    public String printQuantity() {
        return String.format("(%d %s): ", qty, qty == 1 ? "cuota" : "cuotas");
    }
}
