package steps;

public class SeleccionDeEnvio implements CheckoutStep {

    private final CheckoutStep suggestedStep;

    public SeleccionDeEnvio() {
        this.suggestedStep = new SeleccionDeMedioDePago();
    }

    public SeleccionDeEnvio(CheckoutStep suggestedStep) {
        this.suggestedStep = suggestedStep;
    }

    public CheckoutStep envioADomicilio() {
        return suggestedStep;
    }

    public CheckoutStep retiroEnCorreo() {
        return new MapaDeSucursales();
    }
}
