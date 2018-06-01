import payments.GatewayApi;
import payments.Tarjeta;

public class GatewayApiNotRequiredSecCode extends GatewayApi {
    @Override
    public Object returnIfSecCodeIsRequiredElse(Tarjeta tarjeta, Object secCode, Object review) {
        return review;
    }
}
