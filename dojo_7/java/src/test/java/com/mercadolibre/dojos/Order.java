package com.mercadolibre.dojos;

import java.util.*;

/**
 * Created by npuglisi on 18/8/17.
 */
public class Order {
    private PriorityQueue<PaymentMethod> paymentMethods = new PriorityQueue<>(new PaymentMethodComparator());
    private Amount orderAmount = null;
    private ShippingMethod shippingMethod = new AgreeShipping();

    public Order(Amount orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String printPaymentDetails() {
        List<String> contributions = printContributions(paymentMethods);
        return String.join(" - ", contributions);
    }

    private List<String> printContributions(Collection<PaymentMethod> paymentMethods) {
        List<String> printedContributions = new ArrayList<>();
        Amount remainingAmount = totalAmout();
        Iterator<PaymentMethod> iterator = paymentMethods.iterator();
        while (iterator.hasNext()) {
            PaymentMethod method = iterator.next();
            Amount contribution = method.contributes(remainingAmount);
            remainingAmount.substract(contribution);
            printedContributions.add(method.printDetail(contribution));
        }
        return printedContributions;
    }

    private Amount totalAmout() {
        return shippingMethod.amount().plus(orderAmount);
    }

    public void payWith(PaymentMethod paymentMethod) {
        this.paymentMethods.add(paymentMethod);
    }

    public void shipWith(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
