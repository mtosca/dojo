package com.mercadolibre.dojos.dto;



import java.util.List;
import java.util.Map;

/**
 * Created by bweinberg on 10/11/15.
 */
public class OptionDto {

    private String type;
    private String icon;
    private String title;
    private String description;

//    //Need a map becaus GSON don't know how to deserialize RawDataDto
//    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD",
//        justification = "We erase the setter because is not more necessary "
//            + "for gson and is not used but findbugs don`t understand how is filling the field")
    private Map<String, Object> model;  //Don't add to parcel
//    private RawDataDto rawDataModel;
//
//    private OptionModelDto optionModel;
    private List<OptionDto> subOptions; //Flag to enable distances option
    private boolean distanceToBranches;
    // Don't add to parcel - We need this to sort the option list in payment grouping
    private Double distance;
    private String formattedDistance;
    private String rowDisplayType;

    public OptionDto() {
        // default constructor
    }

    /**
     * Getter method for {@link #type}.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for {@link #type}.
     */
    public void setType(String type) {
        this.type = type;
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
     * Getter method for {@link #description}.
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

    public String getFormattedDistance() {
        return formattedDistance;
    }

    public void setFormattedDistance(String formattedDistance) {
        this.formattedDistance = formattedDistance;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

//    /**
//     * Getter method for {@link #model}.
//     */
//    public RawDataDto getModel() {
//        if (rawDataModel == null && model != null) {
//            setModel(model);
//        }
//        return rawDataModel;
//    }
//
//    /**
//     * Setter method for {@link #model}.
//     */
//    public void setModel(Object model) {
//        rawDataModel = RawDataDto.fromObject(model);
//    }
//
//    /**
//     * Getter method for {@link #optionModel}.
//     */
//    public OptionModelDto getOptionModel() {
//        return optionModel;
//    }

    /**
     * Getter method for {@link #distanceToBranches}.
     */
    public boolean isDistanceToBranches() {
        return distanceToBranches;
    }

    /**
     * Setter method for {@link #distanceToBranches}.
     */
    public void setDistanceToBranches(boolean distanceToBranches) {
        this.distanceToBranches = distanceToBranches;
    }

//    /**
//     * Setter method for {@link #optionModel}.
//     */
//    public void setOptionModel(OptionModelDto optionModel) {
//        this.optionModel = optionModel;
//    }

    /**
     * Getter method for {@link #subOptions}.
     */
    public List<OptionDto> getSubOptions() {
        return subOptions;
    }

    /**
     * Setter method for {@link #subOptions}.
     */
    public void setSubOptions(List<OptionDto> subOptions) {
        this.subOptions = subOptions;
    }

    /**
     * Getter method for {@link #rowDisplayType}.
     */
    public String getRowDisplayType() {
        return rowDisplayType;
    }

    /**
     * Setter method for {@link #rowDisplayType}.
     */
    public void setRowDisplayType(String rowDisplayType) {
        this.rowDisplayType = rowDisplayType;
    }

}
