package com.mercadolibre.dojos;


import com.mercadolibre.dojos.dto.*;
import com.mercadolibre.dojos.util.PaymentMethodType;
import com.mercadolibre.dojos.util.ShippingMethodType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper class that calculates the next step for the fallback shipping selection.
 * Created by jpperetti on 6/6/16.
 */
public final class InconsistencyCalculator {

    // identifier used to designate an item that doesn't has shipping specified
    private static final String SHIPPING_MODE_NOT_SPECIFIED = "not_specified";

    // identifier used to designate an item that has mercadoenvios as shipping specified
    private static final String SHIPPING_MODE_MERCADO_ENVIOS_2 = "me2";

    // identifier used to designate an item that has mercadoenvios as shipping specified
    private static final String SHIPPING_MODE_MERCADO_ENVIOS_1 = "me1";

    private InconsistencyCalculator() {
        // private method
    }

    /**
     * Defines the possible actions that the user can take in the screen
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Inconsistency {
        /**
         * Indicates that there is no inconsistency in the shipping options
         */
        int NONE = 0;

        /**
         * Indicates that we can't send the amount of units selected by the user
         */
        int CANT_SENT_X_UNITS = 1;

        /**
         * Indicates that the product can only be sent (no local pickup option) - update: it can
         * only be sent means that the item has custom shipping (no mercadoenvios)
         */
        int ONLY_CAN_BE_SENT = 2;

        /**
         * Indicates that the shipping can only be agreed.
         */
        int ONLY_TO_AGREE = 3;

        /**
         * Indicates that both the payment and the shipping can only be agreed.
         */
        int AGREE_AGREE = 4;

        /**
         * Indicates that the shipping can only be pickup in store.
         */
        int ONLY_PUIS = 5;
    }

    /**
     * Calculates the inconsistency (in case that there is one) related to the shipping
     * options and the quantity selected by the user.
     *
     * @param checkoutContext - the CheckoutContext that contains the base data to make the calculations.
     * @return an Inconsistency value that indicates the current case.
     */
    @Inconsistency
    public static int getInconsistencyValue(CheckoutContext checkoutContext) {
        @Inconsistency
        int inconsistency = Inconsistency.NONE;
        CheckoutOptionsDto checkoutOptions = checkoutContext.getCheckoutOptionsDto();

        if (itemCanOnlyBeSent(checkoutOptions)) {
            // case: (fallback) only can be sent, no geolocation and no pre-loaded addresses
            inconsistency = Inconsistency.ONLY_CAN_BE_SENT;
        } else if (itemCantSendUnitsAndHasLocalPickup(checkoutOptions)) {
            // case: can't send quantity and the product has agreement (shipping) ->  product with mercadoenvios and a one Shipping option (local_pickup)
            inconsistency = Inconsistency.CANT_SENT_X_UNITS;
        } else if (isAgreeAgree(checkoutOptions)) {
            // case: (fallback) only to agree, no geolocation and no pre-loaded addresses, only agree payment
            inconsistency = Inconsistency.AGREE_AGREE;
        } else if (isShippingToAgreeOnly(checkoutOptions)) {
            // case: (fallback) only to agree, no geolocation and no pre-loaded addresses
            inconsistency = Inconsistency.ONLY_TO_AGREE;
        } else if (isPickupInStoreOnly(checkoutOptions)) {
            // case: (fallback) only pickup in store, no geolocation and no pre-loaded addresses
            inconsistency = Inconsistency.ONLY_PUIS;
        }

        return inconsistency;
    }

    /**
     * Determinate if the item being bought by the user cant be sent (because of the amount of units) and has local pickup
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if the item can only be sent, false any other case.
     */
    private static boolean itemCantSendUnitsAndHasLocalPickup(CheckoutOptionsDto checkoutOptions) {
        boolean canOnlyBeSent = false;
        ItemShippingDto itemShippingDto = checkoutOptions.getItem().getShipping();
        // first, verify the item
        if (SHIPPING_MODE_MERCADO_ENVIOS_1.equals(itemShippingDto.getMode())
            || SHIPPING_MODE_MERCADO_ENVIOS_2.equals(itemShippingDto.getMode())) {
            // Verify shipping selections
            ShippingDto shippingDto = checkoutOptions.getShipping();
            canOnlyBeSent = shippingDto.getShippingMethods().getShippingSelections().size() == 1
                && ShippingMethodType.isLocalPickUp(shippingDto.getShippingMethods().getShippingSelections().get(0).getShippingType());
        }

        return canOnlyBeSent;
    }

    /**
     * Determinate if the item being bought by the user can only be sent by custom shipping (no inconsistency, changes the fallback) -
     * rare case.
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if the item can only be sent, false any other case.
     */
    private static boolean itemCanOnlyBeSent(CheckoutOptionsDto checkoutOptions) {
        // Verify shipping selections
        ShippingDto shippingDto = checkoutOptions.getShipping();
        return shippingDto.getShippingMethods().getShippingSelections().size() == 1
            && ShippingMethodType.isCustomShipping(shippingDto.getShippingMethods().getShippingSelections().get(0).getShippingType());
    }

    /**
     * Verifies if the shipping is only (and exclusively) agreement.
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if it is only to agree, false any other case.
     */
    private static boolean isShippingToAgreeOnly(CheckoutOptionsDto checkoutOptions) {
        boolean isOnlyToAgree = false;
        ShippingDto shippingDto = checkoutOptions.getShipping();
        ItemShippingDto itemShippingDto = checkoutOptions.getItem().getShipping();
        // first, verify the item
        if (SHIPPING_MODE_NOT_SPECIFIED.equals(itemShippingDto.getMode()) && !itemShippingDto.isFreeShipping()) {
            // now verify checkout options
            isOnlyToAgree = isToAgree(shippingDto) && shippingDto.getShippingOptions().size() == 1;
        }
        return isOnlyToAgree;
    }

    /**
     * Verifies if at least one of the ShippingOption is agreement (to agree)
     *
     * @param shippingDto - the ShippingDto that contains all the shipping selections possible
     * @return - true if at least one of the ShippingOption in the model is agreement
     */
    private static boolean isToAgree(ShippingDto shippingDto) {
        boolean isToAgree = false;
        for (ShippingOptionDto shippingOptionDto : shippingDto.getShippingOptions()) {
            if (ShippingMethodType.isToAgree(shippingOptionDto.getShippingType())) {
                isToAgree = true;
                break;
            }
        }
        return isToAgree;
    }

    /**
     * Verifies if both the shipping and the payment are to agree
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return if this is an agree-agree case
     */
    private static boolean isAgreeAgree(CheckoutOptionsDto checkoutOptions) {
        return isShippingToAgreeOnly(checkoutOptions) && isPaymentToAgreeOnly(checkoutOptions);
    }

    /**
     * Verifies if the only payment option is to agree
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return if there is only one available payment type and it is to agree
     */
    private static boolean isPaymentToAgreeOnly(CheckoutOptionsDto checkoutOptions) {
        return checkoutOptions.getPayment().getPaymentOptions().getOptions().size() == 1
            && PaymentMethodType.isCash(checkoutOptions.getPayment().getPaymentOptions().getOptions().get(0).getType());
    }

    /**
     * Determinate if the item being bought by the user can only be picked up in store (no inconsistency, changes the fallback)
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if the item can only be picked up in store, false any other case.
     */
    private static boolean isPickupInStoreOnly(CheckoutOptionsDto checkoutOptions) {
        List<ShippingSelectionDto> shippingSelections = checkoutOptions.getShipping().getShippingMethods().getShippingSelections();
        boolean isPUISOnly = !shippingSelections.isEmpty(); // List may have at least one element to reset flag to true
        for (ShippingSelectionDto shippingSelection : shippingSelections) {
            if (!ShippingMethodType.isPickUpInStore(shippingSelection.getShippingType())) {
                isPUISOnly = false;
                break;
            }
        }
        return isPUISOnly;
    }

}

