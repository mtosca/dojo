package steps;

import payments.Boleto;
import payments.GatewayApi;
import payments.MedioDePago;
import payments.Tarjeta;

public class SeleccionDeMedioDePago implements CheckoutStep {

    public CheckoutStep tarjetaPrecargada(Tarjeta tarjeta, GatewayApi gatewayApi) {
        return (CheckoutStep) gatewayApi.returnIfSecCodeIsRequiredElse(tarjeta, new SecCode(), new Review());
    }

    public AltaDeTarjeta altaDeTarjeta() {
        return new AltaDeTarjeta();
    }

    public Review seleccionar(MedioDePago medioDePago) {
        return new Review();
    }
}
