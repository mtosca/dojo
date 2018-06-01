package payments;


import java.math.BigDecimal;

public class Boleto implements MedioDePago {

    // esto tiene que ser un nuevo type Price
    private final BigDecimal minAmount = new BigDecimal(0);
    private final BigDecimal maxAmount = new BigDecimal(10000);

    private final BigDecimal paymentAmount;

    public Boleto(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean puedePagar() {
        return this.minAmount.min(this.paymentAmount) != this.paymentAmount
                && this.maxAmount.max(this.paymentAmount) != this.paymentAmount;
    }
}
