package com.foxminded.borisnij;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivider {

    public List<IntegerDivisionStep> divide(int dividend, int divisor) {
        List<IntegerDivisionStep> steps = new ArrayList<>();

        String dividendStr = String.valueOf(dividend);
        int partialDividend = 0;

        for (int i = 0; i < dividendStr.length(); i++) {
            int dividendDigit = Character.getNumericValue(dividendStr.charAt(i));
            partialDividend = partialDividend * 10 + dividendDigit;

            if (partialDividend >= divisor) {
                int quotientDigit = partialDividend / divisor;
                int divisorMultiple = quotientDigit * divisor;
                steps.add(new IntegerDivisionStep(partialDividend,
                                                  divisorMultiple,
                                                  Character.forDigit(quotientDigit, 10)));

                partialDividend -= divisorMultiple;
            } else if (!steps.isEmpty()) {
                // Add the step with quotient digit 0 even if partialDividend < divisor
                steps.add(new IntegerDivisionStep(partialDividend,
                                                  0,
                                                  Character.forDigit(0, 10)));
            }
        }
        steps.add(new IntegerDivisionStep(partialDividend, 0, '\0'));
        return steps;
    }
}
