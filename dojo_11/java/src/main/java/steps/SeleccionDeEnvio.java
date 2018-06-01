package steps;

import payments.Boleto;
import payments.InconsistenciaDeMedioDePago;
import payments.MedioDePago;

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

    public CheckoutStep expressADomicilio(MedioDePago medioDePago) {
        if (!medioDePago.puedePagar()) {
            return new InconsistenciaDeMedioDePago();
        }

        return this.suggestedStep;
    }

    public CheckoutStep retiroEnCorreo() {
        return new MapaDeSucursales();
    }
}
