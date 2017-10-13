package com.mercadolibre.dojos.util;

/**
 * Helper class that holds payment method types recognized by the app
 * <p/>
 * Created by lgarbarini on 12/1/16.
 */
public final class PaymentMethodType {

    public static final String PREPAID_CARD = "prepaid_card";
    public static final String DEBIT_CARD = "debit_card";
    public static final String CREDIT_CARD = "credit_card";
    public static final String STORED_CARD = "stored_card";
    public static final String ACCOUNT_MONEY = "account_money";
    public static final String CONSUMER_CREDITS = "consumer_credits";
    public static final String TICKET = "ticket";
    public static final String CASH = "cash";
    public static final String TRANSFER = "transfer";
    public static final String PAY_POINT = "pay_point";
    public static final String ATM = "atm";
    public static final String BANK_TRANSFER = "bank_transfer";

    private PaymentMethodType() {
        // hide constructor
    }

//    /**
//     * Iterate the options's list and return the first element that is a stored card
//     *
//     * @param options list
//     * @return the first option that is a stored card
//     */
//    @Nullable
//    public static StoredCardDto getStoredCardFromOptions(@NonNull List<OptionDto> options) {
//        StoredCardDto selectedCard = null;
//        for (OptionDto option : options) {
//            if (isStoredCard(option.getType())) {
//                selectedCard = (StoredCardDto) option.getOptionModel();
//                break;
//            }
//        }
//
//        return selectedCard;
//    }

    /**
     * Check if this payment method type is stored card type
     *
     * @param type the payment type to check
     * @return true if it is stored card
     */
    public static boolean isStoredCard(String type) {
        return STORED_CARD.equals(type);
    }

    /**
     * Check if this payment option is ticket.
     *
     * @param type the payment type to check
     * @return true if it is ticket
     */
    public static boolean isTicket(String type) {
        return TICKET.equals(type);
    }

//    /**
//     * Check if this payment option is credit card.
//     *
//     * @param paymentOptionDto the payment option model
//     * @return if is credit card
//     */
//    public static boolean isAnyCard(OptionModelDto paymentOptionDto) {
//        return paymentOptionDto instanceof CardDto;
//    }
//
//    /**
//     * Check if this payment option is a stored card. Includes new cards generated in the flow
//     *
//     * @param paymentOptionDto the payment option model
//     * @return if this is a stored card
//     */
//    public static boolean isStoredCard(OptionModelDto paymentOptionDto) {
//        return paymentOptionDto instanceof StoredCardDto;
//    }
//
//    /**
//     * Check if this payment option is a consumer credit option
//     *
//     * @param paymentOptionDto the payment option model
//     * @return if it is a credit
//     */
//    public static boolean isConsumerCredits(OptionModelDto paymentOptionDto) {
//        return paymentOptionDto instanceof ConsumerCreditsDto;
//    }

    /**
     * Check if this payment method type is credit card type
     *
     * @param type the payment type to check
     * @return true if it is credit card
     */
    public static boolean isCreditCard(String type) {
        return CREDIT_CARD.equals(type);
    }

    /**
     * Check if this payment method type is debit card type
     *
     * @param type the payment type to check
     * @return true if it is debit card
     */
    public static boolean isDebitCard(String type) {
        return DEBIT_CARD.equals(type);
    }

    /**
     * Check if this payment method type is prepaid card type
     *
     * @param type the payment type to check
     * @return true if it is prepaid card
     */
    public static boolean isPrepaidCard(String type) {
        return PREPAID_CARD.equals(type);
    }
//
//    /**
//     * Check if this payment option is a new card created in the flow
//     *
//     * @param paymentOptionDto the payment option model
//     * @return if this is a new card
//     */
//    public static boolean isNewCard(OptionModelDto paymentOptionDto) {
//        return paymentOptionDto instanceof NewCardDto;
//    }

    /**
     * Check if this payment method type is account money type
     *
     * @param type the payment type to check
     * @return true if it is account money
     */
    public static boolean isAccountMoney(String type) {
        return ACCOUNT_MONEY.equals(type);
    }

    /**
     * Check if this payment method type is cash / agree with seller.
     *
     * @param type the payment type to check
     * @return if is cash
     */
    public static boolean isCash(String type) {
        return CASH.equals(type);
    }

    /**
     * Check if this payment method type is in a pay point
     *
     * @param type the payment type to check
     * @return true if the type is pay point, false otherwise
     */
    public static boolean isPayPoint(String type) {
        return PAY_POINT.equals(type);
    }

    /**
     * Check if this payment method type is transfer
     *
     * @param type the payment type to check
     * @return true if the type is transfer, false otherwise
     */
    public static boolean isTransfer(String type) {
        return TRANSFER.equals(type);
    }

    /**
     * Check if this payment method type is atm
     *
     * @param type the payment type to check
     * @return true if the type is atm, false otherwise
     */
    public static boolean isAtm(String type) {
        return ATM.equals(type);
    }

//    /**
//     * Check if this payment is pending accreditation
//     *
//     * @param paymentOption the payment option
//     * @return true for cash and ticket. False otherwise
//     */
//    public static boolean isPaymentPending(OptionModelDto paymentOption) {
//        return isCash(paymentOption.getPaymentTypeId()) || isTicket(paymentOption.getPaymentTypeId())
//            || isPayPoint(paymentOption.getPaymentTypeId()) || isTransfer(paymentOption.getPaymentTypeId());
//    }
//
//    /**
//     * Check if this is an option to add card.
//     *
//     * @param paymentOption the payment option
//     * @return true when we need to load a card. False when it is a loaded card
//     */
//    public static boolean isAddCard(OptionModelDto paymentOption) {
//        return paymentOption instanceof CardDto && !(paymentOption instanceof StoredCardDto);
//    }
}
