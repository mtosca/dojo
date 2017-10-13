package com.mercadolibre.dojos.dto;




/**
 * Global object for specifying the payment of the checkout
 * <p>
 * Created by jucciani on 10/12/15.
 */
public class PaymentDto {

    private PaymentOptionsDto paymentOptions;
//    private SettingsDto settings;
//    private CouponDto coupon;
//    private List<PaymentPresetsDto> presets;
//    private CombinationDto combination;

    public PaymentDto() {
        //empty constructor
    }

    public PaymentOptionsDto getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(PaymentOptionsDto paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

//    public SettingsDto getSettings() {
//        return settings;
//    }
//
//    public void setSettings(SettingsDto settings) {
//        this.settings = settings;
//    }
//
//    public CouponDto getCoupon() {
//        return coupon;
//    }
//
//    public void setCoupon(CouponDto coupon) {
//        this.coupon = coupon;
//    }
//
//    public List<PaymentPresetsDto> getPresets() {
//        return presets;
//    }
//
//    public void setPresets(List<PaymentPresetsDto> presets) {
//        this.presets = presets;
//    }
//
//    public CombinationDto getCombination() {
//        return combination;
//    }
//
//    public void setCombination(final CombinationDto combination) {
//        this.combination = combination;
//    }

}
