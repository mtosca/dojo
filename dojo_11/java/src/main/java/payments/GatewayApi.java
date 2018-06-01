package payments;

public abstract class GatewayApi {
    public abstract Object returnIfSecCodeIsRequiredElse(Tarjeta tarjeta, Object secCode, Object review);
}
