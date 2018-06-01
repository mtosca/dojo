package steps;

public class Review implements CheckoutStep{

    public SeleccionDeEnvio modificarEnvio() {
        return new SeleccionDeEnvio(this);
    }

    public SeleccionDeMedioDePago modificarMedioDePago() {
        return new SeleccionDeMedioDePago();
    }
}
