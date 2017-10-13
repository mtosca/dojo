package com.mercadolibre.dojos;

/**
 * Created by npuglisi on 15/9/17.
 */
public class GiftCard implements PaymentMethod {

    private final Amount gift;

    public GiftCard(Amount gift) {
        this.gift = gift;
    }

    public String printDetail(Amount amount) {
        return "Giftcard: " + amount.print();
    }

    public Amount contributes(Amount remainingAmount) {
        return gift.min(remainingAmount);
    }

    @Override
    public boolean hasLimitedBalance() {
        return true;
    }
}
