import harnesses.ResourceLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class JSONMapperTest {
    @Test
    public void test_load_json_from_resources() throws IOException {
        Map congrats = JSONMapper.toObject(
                ResourceLoader.getFileAsString("congrats/congrats/congrats_order_paid_off_for_ios_8_10_0.json"),
                Map.class
        );

        assertEquals(congrats.get("status"), "success" /* order id */);
    }
}
