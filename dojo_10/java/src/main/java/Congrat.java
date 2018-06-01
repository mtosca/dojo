import java.util.List;
import java.util.Map;

public class Congrat {
    private final Map congrats;

    public Congrat(Map congrats) {
        this.congrats = congrats;
    }

    public Map asMap(Cliente cliente) {
        cliente.transform(this);
        return congrats;
    }

    protected void removeSection(String sectionName) {
        ((List<Map>)congrats.get("sections")).removeIf(x -> x.get("type").equals(sectionName));
    }

    protected void replaceOfflinePaymentType(String newTypeName) {
        ((List<Map>)congrats.get("sections")).get(0).put("type", newTypeName);
    }
}
