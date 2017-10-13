package com.mercadolibre.dojos.util;

import com.mercadolibre.dojos.dto.ShippingOptionDto;

/**
 * Helper class that holds shipping method types recognized by the app
 * <p/>
 * Created by mbel on 12/1/16.
 */
public final class ShippingMethodType {

    public static final String PICK_UP_SELECTION = "pick_up";

    private ShippingMethodType() {
        // hide constructor
    }

    /**
     * Check if this shipping method type is mercadoenvios
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is mercadoenvios
     */
    public static boolean isMercadoEnviosShipping(final String shippingTypeId) {
        return ShippingOptionDto.MERCADO_ENVIOS_SHIPPING_TYPE.equals(shippingTypeId) || isStorePickUp(shippingTypeId);
    }

    /**
     * Check if this shipping method type is custom
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is cs
     */
    public static boolean isCustomShipping(final String shippingTypeId) {
        return ShippingOptionDto.CUSTOM_SHIPPING_TYPE.equals(shippingTypeId);
    }

    /**
     * Check if this shipping method type is free_shipping (No ME)
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is freeShipping (No ME)
     */
    public static boolean isFreeShipping(final String shippingTypeId) {
        return ShippingOptionDto.FREE_SHIPPING_TYPE.equals(shippingTypeId);
    }

    /**
     * Check if this shipping method type is to agree
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is to be agree
     */
    public static boolean isToAgree(final String shippingTypeId) {
        return ShippingOptionDto.TO_AGREE_SHIPPING_TYPE.equals(shippingTypeId);
    }

    /**
     * Check if this shipping method type is of pick_up
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is pick_up
     */
    public static boolean isPickUp(final String shippingTypeId) {
        return PICK_UP_SELECTION.equals(shippingTypeId) || isLocalPickUp(shippingTypeId)
                || isStorePickUp(shippingTypeId) || isPickUpInStore(shippingTypeId);
    }

    /**
     * Check if this shipping method type is local_pick_up
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is local_pick_up
     */
    public static boolean isLocalPickUp(final String shippingTypeId) {
        return ShippingOptionDto.LOCAL_PICK_UP_TYPE.equals(shippingTypeId);
    }

    /**
     * Check if this shipping method type is store_pick_up
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is store_pick_up
     */
    public static boolean isStorePickUp(final String shippingTypeId) {
        return ShippingOptionDto.STORE_PICK_UP_TYPE.equals(shippingTypeId);
    }

    /**
     * Check if this shipping method type is pick_up_in_store
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is pick_up_in_store
     */
    public static boolean isPickUpInStore(final String shippingTypeId) {
        return ShippingOptionDto.PICK_UP_IN_STORE_TYPE.equals(shippingTypeId);
    }

    /**
     * Check if this shipping method type is for a pickup point
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is store_pick_up or pick_up_in_store
     */
    public static boolean isPickUpPoint(final String shippingTypeId) {
        return isStorePickUp(shippingTypeId) || isPickUpInStore(shippingTypeId);
    }

    /**
     * Check if this shipping method type is to agree, local_pick_up or store_pick_up
     *
     * @param shippingTypeId the shipping type to check
     * @return true if it is to agree, local_pick_up or store_pick_up
     */
    public static boolean isNoShippingOption(final String shippingTypeId) {
        return isToAgree(shippingTypeId) || isLocalPickUp(shippingTypeId) || isStorePickUp(shippingTypeId) || isPickUpInStore(shippingTypeId);
    }
}
