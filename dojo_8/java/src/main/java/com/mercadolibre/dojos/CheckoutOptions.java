package com.mercadolibre.dojos;

import com.mercadolibre.dojos.dto.*;
import com.mercadolibre.dojos.util.PaymentMethodType;
import com.mercadolibre.dojos.util.ShippingMethodType;

import java.util.List;

/**
 * Created by dsanchez on 11/10/17.
 */
public class CheckoutOptions {
    // identifier used to designate an item that doesn't has shipping specified
    private static final String SHIPPING_MODE_NOT_SPECIFIED = "not_specified";

    // identifier used to designate an item that has mercadoenvios as shipping specified
    private static final String SHIPPING_MODE_MERCADO_ENVIOS_2 = "me2";

    // identifier used to designate an item that has mercadoenvios as shipping specified
    private static final String SHIPPING_MODE_MERCADO_ENVIOS_1 = "me1";


    private final CheckoutOptionsDto dto;

    public CheckoutOptions( CheckoutOptionsDto dto) {
        this.dto = dto;
    }

    /**
     * Determinate if the item being bought by the user cant be sent (because of the amount of units) and has local pickup
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if the item can only be sent, false any other case.
     */
    public boolean itemCantSendUnitsAndHasLocalPickup() {
        boolean canOnlyBeSent = false;
        ItemShippingDto itemShippingDto = dto.getItem().getShipping();
        // first, verify the item
        if (SHIPPING_MODE_MERCADO_ENVIOS_1.equals(itemShippingDto.getMode())
                || SHIPPING_MODE_MERCADO_ENVIOS_2.equals(itemShippingDto.getMode())) {
            // Verify shipping selections
            ShippingDto shippingDto = dto.getShipping();
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
    public boolean itemCanOnlyBeSent() {
        // Verify shipping selections
        final ShippingDto shippingDto = dto.getShipping();
        return shippingDto.getShippingMethods().getShippingSelections().size() == 1
                && ShippingMethodType.isCustomShipping(
                        shippingDto.getShippingMethods().getShippingSelections()
                                .get(0).getShippingType()
                );
    }

    /**
     * Verifies if the shipping is only (and exclusively) agreement.
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if it is only to agree, false any other case.
     */
    public boolean isShippingToAgreeOnly() {
        boolean isOnlyToAgree = false;
        ShippingDto shippingDto = dto.getShipping();
        ItemShippingDto itemShippingDto = dto.getItem().getShipping();
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
    public boolean isToAgree(ShippingDto shippingDto) {
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
    public boolean isAgreeAgree() {
        return isShippingToAgreeOnly() && isPaymentToAgreeOnly();
    }

    /**
     * Verifies if the only payment option is to agree
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return if there is only one available payment type and it is to agree
     */
    public boolean isPaymentToAgreeOnly() {
        return dto.getPayment().getPaymentOptions().getOptions().size() == 1
                && PaymentMethodType.isCash(dto.getPayment().getPaymentOptions().getOptions().get(0).getType());
    }

    /**
     * Determinate if the item being bought by the user can only be picked up in store (no inconsistency, changes the fallback)
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if the item can only be picked up in store, false any other case.
     */
    public boolean isPickupInStoreOnly() {
        List<ShippingSelectionDto> shippingSelections = dto.getShipping().getShippingMethods().getShippingSelections();
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
