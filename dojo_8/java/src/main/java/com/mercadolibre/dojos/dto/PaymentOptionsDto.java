package com.mercadolibre.dojos.dto;



import java.util.List;

/**
 * Created by bweinberg on 17/11/15.
 */
public class PaymentOptionsDto {

    private String title;
    private String subtitle;
    private List<OptionDto> options;
//    private ActionDto action;

    public PaymentOptionsDto() {
        //empty constructor
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
     * Getter method for {@link #options}.
     */
    public List<OptionDto> getOptions() {
        return options;
    }

    /**
     * Setter method for {@link #options}.
     */
    public void setOptions(List<OptionDto> options) {
        this.options = options;
    }

//    /**
//     * Getter method for {@link #action}.
//     */
//    public ActionDto getAction() {
//        return action;
//    }
//
//    /**
//     * Setter method for {@link #action}.
//     */
//    public void setAction(ActionDto action) {
//        this.action = action;
//    }
}
