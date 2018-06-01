import payments.GatewayApi;
import payments.Tarjeta;

public class GatewayApiRequiredSecCode extends GatewayApi {
    @Override
    public Object returnIfSecCodeIsRequiredElse(Tarjeta tarjeta, Object secCode, Object review) {
        return secCode;
    }
}
