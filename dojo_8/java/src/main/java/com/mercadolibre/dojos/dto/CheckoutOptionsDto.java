package com.mercadolibre.dojos.dto;


/**
 * Created by lgarbarini on 6/10/15.
 */
public class CheckoutOptionsDto {

    private ItemDto item;
    private ShippingDto shipping;
    private PaymentDto payment;
//    private OrderDto order;
//    private BuyerDto buyer;
//    private UserIdentificationDto userIdentification;
//    private SellerDTO seller;

    //Stores the flow type
    private String flowType;

//    public CheckoutOptionsDto() {
//        userIdentification = new UserIdentificationDto();
//    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public ShippingDto getShipping() {
        return shipping;
    }

    public void setShipping(ShippingDto shipping) {
        this.shipping = shipping;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }

//    public OrderDto getOrder() {
//        return order;
//    }
//
//    public void setOrder(OrderDto order) {
//        this.order = order;
//    }
//
//    public BuyerDto getBuyer() {
//        return buyer;
//    }
//
//    public void setBuyer(BuyerDto buyer) {
//        this.buyer = buyer;
//    }
//
//    public SellerDTO getSeller() {
//        return seller;
//    }
//
//    public void setSeller(SellerDTO seller) {
//        this.seller = seller;
//    }
//
//    @NonNull
//    public UserIdentificationDto getUserIdentification() {
//        if (userIdentification == null) {
//            userIdentification = new UserIdentificationDto();
//        }
//        return userIdentification;
//    }
//
//    /**
//     * Setter for {@link #flowType}.
//     *
//     * @param flowType the type of payment only flow
//     */
//    public void setFlowType(@FlowType final String flowType) {
//        this.flowType = flowType;
//    }
//
//    /**
//     * Getter for {@link #flowType}.
//     */
//    @FlowType
//    public String getFlowType() {
//        if (flowType == null) {
//            flowType = FlowType.PURCHASE;
//        }
//        return flowType;
//    }
}
