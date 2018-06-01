package steps;

public class SecCode implements CheckoutStep {
    public Review acceptSecCode() {
        return new Review();
    }
}
