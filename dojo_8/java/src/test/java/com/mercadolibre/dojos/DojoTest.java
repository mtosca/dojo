package com.mercadolibre.dojos;


import com.google.gson.GsonBuilder;
import com.mercadolibre.dojos.dto.CheckoutOptionsDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for the dojo.
 */
public class DojoTest {

    @Test
    public void test() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("options.json"), CheckoutOptionsDto.class);

        Assert.assertEquals("MLA0000001", checkoutOptionsDto.getItem().getId());
    }

    @Test
    public void onlyToAgree() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("only_to_agree.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.ONLY_TO_AGREE, inconsistency);
    }

    @Test
    public void cantSentXUnits() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("cant_sent_x_units.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.CANT_SENT_X_UNITS, inconsistency);
    }

    @Test
    public void agreeAgree() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("agree_agree.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.AGREE_AGREE, inconsistency);
    }

    @Test
    public void onlyCanBeSent() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("only_can_be_sent.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.ONLY_CAN_BE_SENT, inconsistency);
    }

    @Test
    public void onlyPuis() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("only_puis.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.ONLY_PUIS, inconsistency);
    }

    @Test
    public void test_none_vs_only_puis() throws Exception {
        CheckoutOptionsDto dto = new GsonBuilder().create().fromJson(loadFile("only_puis.json"), CheckoutOptionsDto.class);
        CheckoutOptions options = new CheckoutOptions(dto);

        NoneInconsitencia none = new NoneInconsitencia( options );
        OnlyPuis onlyPuis = new OnlyPuis( options );

        assertEquals(onlyPuis, none.challenge(onlyPuis));
    }

    @Test
    public void test_only_puis_vs_none() throws Exception {
        CheckoutOptionsDto dto = new GsonBuilder().create().fromJson(loadFile("only_puis.json"), CheckoutOptionsDto.class);
        CheckoutOptions options = new CheckoutOptions(dto);

        NoneInconsitencia none = new NoneInconsitencia( options );
        OnlyPuis onlyPuis = new OnlyPuis( options );

        assertEquals(onlyPuis, onlyPuis.challenge(none));
    }



    private InputStreamReader loadFile(String filename) {
        return new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
    }

}
