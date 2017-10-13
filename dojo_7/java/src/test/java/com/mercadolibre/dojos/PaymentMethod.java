package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 18/8/17.
 */
public interface PaymentMethod {
    String printDetail(Amount orderAmount);

    Amount contributes(Amount remainingAmount);

    Amount contribution();
}
