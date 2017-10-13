package com.mercadolibre.dojos.dto;



import java.math.BigDecimal;

/**
 * Created by lgarbarini on 7/10/15.
 */
@SuppressWarnings("PMD.TooManyFields")
public class ItemDto {

    private String id;
    private String siteId;
    private String title;
    private BigDecimal price;
    private String currencyId;
    private String picture;
    private int availableQuantity;
    private int quantity;
    private String sellerId;
    private String categoryId;
    private String buyingMode;
//    private VariationDto variation;
    private ItemShippingDto shipping;
    private String shippingType;

    //For payment only checkout
    private BigDecimal basePrice;
    private String basePriceCurrencyId;
//    private ReviewItemDto review;

    public ItemDto() {
        // default constructor
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
     * Getter method for {@link #siteId}.
     */
    public String getSiteId() {
        return siteId;
    }

    /**
     * Setter method for {@link #siteId}.
     */
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    /**
     * Getter method for {@link #title}.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for {@link #title}.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for {@link #picture}.
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Setter method for {@link #picture}.
     */
    public void setPicture(String picture) {
        this.picture = picture;
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

    /**
     * Getter method for {@link #currencyId}.
     */
    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * Setter method for {@link #currencyId}.
     */
    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * Getter method for {@link #availableQuantity}.
     */
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * Setter method for {@link #availableQuantity}.
     */
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    /**
     * Getter method for {@link #quantity}.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter method for {@link #quantity}.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    /**
//     * Getter method for {@link #variation}.
//     */
//    public VariationDto getVariation() {
//        return variation;
//    }
//
//    /**
//     * Setter method for {@link #variation}.
//     */
//    public void setVariation(VariationDto variation) {
//        this.variation = variation;
//    }

    /**
     * Getter method for {@link #sellerId}.
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Setter method for {@link #sellerId}.
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * Getter method for {@link #categoryId}.
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Setter method for {@link #categoryId}.
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Getter method for {@link #buyingMode}.
     */
    public String getBuyingMode() {
        return buyingMode;
    }

    /**
     * Setter method for {@link #buyingMode}.
     */
    public void setBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
    }

    /**
     * Getter method for {@link #shipping}.
     */
    public ItemShippingDto getShipping() {
        return shipping;
    }

    /**
     * Setter method for {@link #shipping}.
     */
    public void setShipping(ItemShippingDto shipping) {
        this.shipping = shipping;
    }

    /**
     * Getter method for {@link #shippingType}.
     */
    public String getShippingType() {
        return shippingType;
    }

    /**
     * Setter method for {@link #shippingType}.
     */
    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    /**
     * Getter method for {@link #basePrice}.
     */
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    /**
     * Setter method for {@link #basePrice}.
     */
    public void setBasePrice(final BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Getter method for {@link #basePriceCurrencyId}.
     */
    public String getBasePriceCurrencyId() {
        return basePriceCurrencyId;
    }

    /**
     * Setter method for {@link #basePriceCurrencyId}.
     */
    public void setBasePriceCurrencyId(final String basePriceCurrencyId) {
        this.basePriceCurrencyId = basePriceCurrencyId;
    }

//    /**
//     * Getter method for {@link #review}.
//     */
//    public ReviewItemDto getReview() {
//        return review;
//    }
//
//    /**
//     * Setter method for {@link #review}.
//     */
//    public void setReview(final ReviewItemDto review) {
//        this.review = review;
//    }
}
