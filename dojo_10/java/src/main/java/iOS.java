import java.util.List;
import java.util.Map;

public class iOS extends Cliente {

    @Override
    public void transform(Congrat congrats) {
        congrats.replaceOfflinePaymentType("mlu_offline_payment");
    }
}
