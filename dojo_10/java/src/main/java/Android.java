import java.util.Map;

public class Android extends Cliente {

    @Override
    public void transform(Congrat congrats) {
        congrats.replaceOfflinePaymentType("offline_payment");
    }
}
