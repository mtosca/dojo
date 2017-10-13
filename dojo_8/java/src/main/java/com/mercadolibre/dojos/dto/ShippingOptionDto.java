package com.mercadolibre.dojos.dto;

import java.math.BigDecimal;

/**
 * Created by mbel on 13/11/15.
 */
@SuppressWarnings("PMD.TooManyFields")
public class ShippingOptionDto {

    public static final String MERCADO_ENVIOS_SHIPPING_TYPE = "mercadoenvios";
    public static final String CUSTOM_SHIPPING_TYPE = "custom";
    public static final String FREE_SHIPPING_TYPE = "free_shipping";
    public static final String TO_AGREE_SHIPPING_TYPE = "to_agree";
    public static final String LOCAL_PICK_UP_TYPE = "local_pick_up";
    // Carrier store that receive item by ME and keeps it until user picks it up
    public static final String STORE_PICK_UP_TYPE = "store_pick_up";
    // Oficial stores that provide items from its stock
    public static final String PICK_UP_IN_STORE_TYPE = "pick_up_in_store";
    // It is used to get a contact info title when there is no shipping id selected
    public static final String DEFAULT_TYPE = "default";

    private String id;
    private String title;
    private String subtitle;
    private String description;
    private String disclaimer;
    private BigDecimal price;
    private String currencyId;
    private String display;

//    private SpecialDiscountDto discount;
    // possible values: mercadoenvios | store_pick_up | pick_up_in_store | custom | local_pick_up | to_agree
    private String shippingType;

    //Raw Data to keep original shipping cost when creating the shipment
    private Object rawData;

    private String icon;
    private String disclosure;

    //Used for disclaimers on review
    private String deliveryTime;
//    private ReviewDisclaimersDto review;

    public ShippingOptionDto() {
        //empty constructor
    }

    /**
     * Getter method for {@link #id}.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for {@link #id}.
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for {@link #title}.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method for {@link #display}, a backend value that
     * informs the default way the package must me shown.
     */
    public String getDisplay() {
        return display;
    }

    /**
     * Setter method for {@link #title}.
     */

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * Getter method for {@link #subtitle}.
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * Setter method for {@link #subtitle}.
     */

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * Getter method for {@link #description}. A tag with "Gratis" or
     * ${price} value
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for {@link #description}.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for {@link #disclaimer}, a message associated with
     * a particular shipping option. Example: "This shipping may include
     * importation fees"
     */
    public String getDisclaimer() {
        return disclaimer;
    }

    /**
     * Getter method for {@link #price}.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Setter method for {@link #price}.
     */

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    /**
//     * Getter method for {@link #rawData}.
//     */
//    public Map<String, Object> getRawData() {
//        return getInnerRawData().toMap();
//    }
//
//    private RawDataDto getInnerRawData() {
//        RawDataDto rawDataDto;
//        if (rawData instanceof RawDataDto) {
//            rawDataDto = ((RawDataDto) rawData);
//        } else {
//            rawDataDto = RawDataDto.fromObject(rawData);
//        }
//        return rawDataDto;
//    }
//
//    /**
//     * Getter method for {@link #discount}.
//     */
//    public SpecialDiscountDto getDiscount() {
//        return discount;
//    }

    /**
     * Setter method for {@link #shippingType}.
     */

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    /**
     * Getter method for {@link #shippingType}.
     */
    public String getShippingType() {
        return shippingType;
    }

    /**
     * Getter method for {@link #icon}.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Setter method for {@link #icon}.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Getter method for {@link #disclosure}.
     */
    public String getDisclosure() {
        return disclosure;
    }

//    /**
//     * Getter method for {@link #review}.
//     */
//    public ReviewDisclaimersDto getReview() {
//        return review;
//    }
//
//    /**
//     * Setter method for {@link #review}.
//     */
//
//    public void setReview(ReviewDisclaimersDto review) {
//        this.review = review;
//    }

    /**
     * Getter method for {@link #deliveryTime}.
     */
    public String getDeliveryTime() {
        return deliveryTime;
    }

}
