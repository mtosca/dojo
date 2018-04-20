package steps;

public class Review extends CheckoutStep{
    public SeleccionDeEnvio modificarEnvio() {
        return new SeleccionDeEnvio(true);
    }
}
