package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 15/9/17.
 */
public class PaymentMethodComparator implements java.util.Comparator<PaymentMethod> {
    public int compare(PaymentMethod o1, PaymentMethod o2) {
        if(o1.hasLimitedBalance())
            return -1;
        else
            return 1;
    }
}
