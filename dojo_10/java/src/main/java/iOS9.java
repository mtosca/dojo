import java.util.Map;

public class iOS9 extends Cliente {

    @Override
    public void transform(Congrat congrats) {
        congrats.removeSection("exit");

        congrats.replaceOfflinePaymentType("mlu_offline_payment");
    }
}
