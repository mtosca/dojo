package steps;

public class AltaDeTarjeta implements CheckoutStep {
    public SecCode nuevaTarjeta() {
        return new SecCode();
    }

    public LectorQR escanearQR() {
        return new LectorQR();
    }
}
