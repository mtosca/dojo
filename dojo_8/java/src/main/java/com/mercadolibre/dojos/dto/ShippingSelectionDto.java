package com.mercadolibre.dojos.dto;


/**
 * Info use to draw the screens with shipping selections.
 * Created by mbel on 1/12/15.
 */
public class ShippingSelectionDto {

    private String id;
    private String shippingType;
    private String title;
    private String description;
    private String methodType;

    public ShippingSelectionDto() {
        // empty constructor
    }

    @Deprecated

    public ShippingSelectionDto(String id, String shippingType, String methodType) {
        this.id = id;
        this.shippingType = shippingType;
        this.methodType = methodType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    @Override
    public boolean equals(Object o) {
        boolean equals = this == o;
        if (!equals && o instanceof ShippingSelectionDto) {
            ShippingSelectionDto that = (ShippingSelectionDto) o;
            equals = id.equals(that.getId())
                    && methodType.equals(that.getMethodType())
                    && shippingType.equals(that.getShippingType());
        }
        return equals;

    }

    @Override
    public int hashCode() {
        return 0;
    }

}
