package com.mercadolibre.dojos;

import com.mercadolibre.dojos.dto.CheckoutOptionsDto;

/**
 * Context information for the resolvers to work out the flow
 * <p/>
 * Created by lgarbarini on 28/10/15.
 */
public class CheckoutContext {

    //Purchase checkoutOptions
    private CheckoutOptionsDto checkoutOptionsDto;

    //POST/PUT response after submitting purchase.
//    private OrderResponseReadDto orderResponseRead;
//
//    // User selected preferences.
//    private final PaymentPreferencesList paymentPreferencesList;
//    private final ShippingPreferences shippingPreferences;
//    private final OrderPreferences orderPreferences;
//    private final UserPreferences userPreferences;
//
//    // Additional info that we need to persist in the flow
//    private final CacheInfo cacheInfo;

    public CheckoutContext() {
//        paymentPreferencesList = new PaymentPreferencesList();
//        shippingPreferences = new ShippingPreferences();
//        orderPreferences = new OrderPreferences();
//        userPreferences = new UserPreferences();
//        cacheInfo = new CacheInfo();
    }

//    public UserPreferences getUserPreferences() {
//        return userPreferences;
//    }

    public void setCheckoutOptionsDto(CheckoutOptionsDto checkoutOptionsDto) {
        this.checkoutOptionsDto = checkoutOptionsDto;
    }

    public CheckoutOptionsDto getCheckoutOptionsDto() {
        return checkoutOptionsDto;
    }

//    public OrderResponseReadDto getOrderResponseRead() {
//        return orderResponseRead;
//    }

//    public void setOrderResponseRead(OrderResponseReadDto orderResponseRead) {
//        this.orderResponseRead = orderResponseRead;
//    }

    // ---- Payment

//    /**
//     * Saves paymentPreferences into context. Preferences will be identified by its reference id
//     *
//     * @param paymentPreferences the preference to save
//     */
//    public void savePaymentPreferences(@NonNull PaymentPreferences paymentPreferences) {
//        paymentPreferencesList.savePaymentPreferences(paymentPreferences);
//    }
//
//    /**
//     * Set this preference as the one being edited now. The preference has to be already saved in the list
//     *
//     * @param paymentPreferences the preferences to edit
//     */
//    public void setCurrentPaymentPreferences(PaymentPreferences paymentPreferences) {
//        paymentPreferencesList.setCurrentPaymentPreferences(paymentPreferences);
//    }
//
//    /**
//     * @return the current paymentPreferences which are being edited.
//     */
//    public PaymentPreferences getPaymentPreferences() {
//        return paymentPreferencesList.getCurrentPaymentPreferences();
//    }
//
//    /**
//     * Get a payment preference by id
//     *
//     * @param id the reference id of the payment
//     * @return the payment preference with the reference id
//     */
//    public PaymentPreferences getPaymentPreferences(String id) {
//        return paymentPreferencesList.getPaymentPreferences(id);
//    }
//
//    /**
//     * @return a list with all the selected payments
//     */
//    public List<PaymentPreferences> getPaymentPreferencesList() {
//        return paymentPreferencesList.getPaymentPreferencesList();
//    }
//
//    /**
//     * @return the payment preferences list manager.
//     */
//    protected PaymentPreferencesList getPaymentPreferencesListWrapper() {
//        return paymentPreferencesList;
//    }
//
//    /**
//     * Clear all selected payment preferences
//     */
//    public void clearPaymentPreferences() {
//        paymentPreferencesList.clearPaymentPreferences();
//    }
//
//    // ---- Shipment
//
//    public ShippingPreferences getShippingPreferences() {
//        return shippingPreferences;
//    }
//
//    public void clearShippingPreferences() {
//        shippingPreferences.setShippingTypeId(null);
//        shippingPreferences.setShippingOption(null);
//        shippingPreferences.setAddress(null);
//        shippingPreferences.clearSelectedDestination();
//    }
//
//    public OrderPreferences getOrderPreferences() {
//        return orderPreferences;
//    }
//
//    /**
//     * Merges stored and cached addresses in a new List.
//     *
//     * @return merged AddressDto List
//     * @deprecated use {@link ContextDelegate#getMergedAddresses(ShippingCacheDelegate, ShippingOptionsDelegate)} instead of this one.
//     */
//    @Deprecated
//    public List<AddressDto> getAddresses() {
//        List<AddressDto> cacheAddresses = cacheInfo.getShippingCache().getAddressCache();
//        List<CheckoutAddressDto> storedAddresses = checkoutOptionsDto.getShipping().getStoredAddresses().getAddresses();
//
//        List<AddressDto> allAddresses;
//        if (cacheAddresses == null) {
//            allAddresses = new ArrayList<>();
//            allAddresses.addAll(storedAddresses);
//        } else {
//            Set<AddressDto> addressSet = new LinkedHashSet<>(cacheAddresses);
//            addressSet.addAll(storedAddresses);
//            allAddresses = new ArrayList<>(addressSet);
//        }
//
//        return allAddresses;
//    }
//
//    public CacheInfo getCacheInfo() {
//        return cacheInfo;
//    }
//
//    /**
//     * Update the cache info
//     */
//    public void setCacheInfo(@NonNull CacheInfo cacheInfo) {
//        this.cacheInfo.update(cacheInfo);
//    }
//
//    /**
//     * Saves order and shipping Ids into cache & preferences so that they will
//     * be used for next purchase PUT.
//     */
//    public void saveOrderShippingIdToContext(@NonNull OrderResponseReadDto orderResponseReadDto) {
//        OrderReadDto orderReadDto = orderResponseReadDto.getOrder();
//        if (orderReadDto != null) {
//            //Save orderId into OrderCache
//            getCacheInfo().getOrderCache().setId(orderReadDto.getId());
//            //Save shippingId
//            if (orderReadDto.getShipment() != null) {
//                //Shipment will be null only when we have a shippingError, otherwise it will always come (empty for to_agree).
//                //Save shippingId into ShippingCache
//                getCacheInfo().getShippingCache().setShipmentId(orderReadDto.getShipment().getId());
//                getShippingPreferences().setShipmentId(orderReadDto.getShipment().getId());
//            }
//        }
//    }
//
//    /**
//     * Create a shallow copy of the context. Only the references are copied.
//     *
//     * @param checkoutContext the context to copy
//     */
//    public CheckoutContext(CheckoutContext checkoutContext) {
//        this.checkoutOptionsDto = checkoutContext.checkoutOptionsDto;
//        this.orderResponseRead = checkoutContext.orderResponseRead;
//        this.paymentPreferencesList = new PaymentPreferencesList(checkoutContext.paymentPreferencesList);
//        this.shippingPreferences = new ShippingPreferences(checkoutContext.getShippingPreferences());
//        this.cacheInfo = checkoutContext.cacheInfo;
//        this.orderPreferences = checkoutContext.orderPreferences;
//        this.userPreferences = checkoutContext.userPreferences;
//    }

}
