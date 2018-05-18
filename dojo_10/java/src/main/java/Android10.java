import java.util.Map;

public class Android10 extends Cliente {

    @Override
    public void transform(Congrat congrats) {
        congrats.removeSection("exit");

        congrats.replaceOfflinePaymentType("offline_payment");
    }
}
