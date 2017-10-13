package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 4/9/17.
 */
public class CreditCardWithLimit implements PaymentMethod {


    private final CreditCard decoratedCard;
    private final Amount limit;

    public CreditCardWithLimit(CreditCard creditCardDecorated, Amount limit) {
        this.decoratedCard = creditCardDecorated;
        this.limit = limit;
    }

    public String printDetail(Amount orderAmount) {
        return decoratedCard.printDetail(orderAmount);
    }

    public Amount contributes(Amount remainingAmount) {
        return limit.min(remainingAmount);
    }

    @Override
    public boolean hasLimitedBalance() {
        return false;
    }
}
