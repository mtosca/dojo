package com.mercadolibre.dojos.dto;



import java.util.ArrayList;
import java.util.List;

/**
 * Information about the available shipping options. Ex. : ME, custom shipping.
 * Created by mbel on 2/12/15.
 */
public class ShippingDto {

    private CheckoutShippingMethodDto shippingMethods;
    private List<ShippingOptionDto> shippingOptions;
//    private InputAddressDto inputAddress;
//    private CheckoutContactInfoDto contactInfo;
//    private StoredAddressesDto storedAddresses;
//    private CheckoutLocatedDestinationDto locatedDestination;
//    private List<ShippingPresetsDto> presets;

    public ShippingDto() {
        //empty constructor
    }

    public CheckoutShippingMethodDto getShippingMethods() {
        return shippingMethods;
    }

    public void setShippingMethods(CheckoutShippingMethodDto shippingMethod) {
        this.shippingMethods = shippingMethod;
    }

    public List<ShippingOptionDto> getShippingOptions() {
        return shippingOptions;
    }

    public void setShippingOptions(List<ShippingOptionDto> shippingOptions) {
        this.shippingOptions = shippingOptions;
    }

//    public InputAddressDto getInputAddress() {
//        return inputAddress;
//    }
//
//    public void setInputAddress(InputAddressDto inputAddress) {
//        this.inputAddress = inputAddress;
//    }
//
//    public CheckoutContactInfoDto getContactInfo() {
//        return contactInfo;
//    }
//
//    public void setContactInfo(CheckoutContactInfoDto contactInfo) {
//        this.contactInfo = contactInfo;
//    }
//
//    public StoredAddressesDto getStoredAddresses() {
//        return storedAddresses;
//    }
//
//    public void setStoredAddresses(StoredAddressesDto storedAddresses) {
//        this.storedAddresses = storedAddresses;
//    }
//
//    public CheckoutLocatedDestinationDto getLocatedDestination() {
//        return locatedDestination;
//    }
//
//    public void setLocatedDestination(CheckoutLocatedDestinationDto locatedDestination) {
//        this.locatedDestination = locatedDestination;
//    }
//
//    public List<ShippingPresetsDto> getPresets() {
//        return presets;
//    }
//
//    public void setPresets(List<ShippingPresetsDto> presets) {
//        this.presets = presets;
//    }


//    public boolean isCustomShippingAvailable() {
//        return shippingMethods != null && shippingMethods.getShippingOptionsGroups().getCustomShipping() != null;
//    }
//
//    public boolean hasStoredAddresses() {
//        return storedAddresses != null
//                && storedAddresses.getAddresses() != null
//                && !storedAddresses.getAddresses().isEmpty();
//    }

}