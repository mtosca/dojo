package com.mercadolibre.dojos;


import com.mercadolibre.dojos.dto.CheckoutOptionsDto;

import java.util.Arrays;
import java.util.List;

/**
 * Helper class that calculates the next step for the fallback shipping selection.
 * Created by jpperetti on 6/6/16.
 */
final class InconsistencyCalculator {

    /**
     * Calculates the inconsistency (in case that there is one) related to the shipping
     * options and the quantity selected by the user.
     *
     * @param checkoutContext - the CheckoutContext that contains the base data to make the calculations.
     * @return an IInconsistency value that indicates the current case.
     */
    @IInconsistency
    static int getInconsistencyValue(CheckoutContext checkoutContext) {
        final List<Inconsistency> inconsistencies = getOrderedInconsistencies(checkoutContext);
        return findTheOneInconsistencyThatIsHappening(inconsistencies).getNumber();
    }

    static List<Inconsistency> getOrderedInconsistencies(CheckoutContext checkoutContext) {
        final CheckoutOptionsDto checkoutOptions = checkoutContext.getCheckoutOptionsDto();
        final CheckoutOptions options = new CheckoutOptions(checkoutOptions);

        return Arrays.asList(
                new NoneInconsitencia(options),
                new OnlyCanBeSent(options),
                new CantSentXunits(options),
                new AgreeAgree(options),
                new OnlyToAgree(options),
                new OnlyPuis(options)
        );
    }

    static Inconsistency findTheOneInconsistencyThatIsHappening(List<Inconsistency> inconsistencies) {
        return inconsistencies.stream()
                .map(Inconsistency::happens)
                .reduce(Inconsistency::challenge)
                .get();
    }


}

