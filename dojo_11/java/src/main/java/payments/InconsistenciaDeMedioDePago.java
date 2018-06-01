package payments;

import steps.CheckoutStep;
import steps.SeleccionDeEnvio;

public class InconsistenciaDeMedioDePago implements CheckoutStep {

    public SeleccionDeEnvio modificarEnvio() {
        return new SeleccionDeEnvio();
    }
}
