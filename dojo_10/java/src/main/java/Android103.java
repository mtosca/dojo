import java.util.Map;

public class Android103 extends Cliente {

    @Override
    public void transform(Congrat congrats) {
        congrats.replaceOfflinePaymentType("OFFLINE_PAYMENT");
    }
}
