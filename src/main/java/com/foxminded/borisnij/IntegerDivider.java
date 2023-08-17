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
            partialDividend = (partialDividend << 3) + (partialDividend << 1) + dividendDigit;

            if (partialDividend >= divisor) {
                int quotientDigit = partialDividend / divisor;
                int divisorMultiple = quotientDigit * divisor;
                updateSteps(steps, partialDividend, divisorMultiple, Character.forDigit(quotientDigit, 10));

                partialDividend -= divisorMultiple;
            } else if (!steps.isEmpty()) {
                updateSteps(steps, partialDividend, 0, Character.forDigit(0, 10));
            }
        }

        updateSteps(steps, partialDividend, 0, '\0');
        return steps;
    }

    private void updateSteps(List<IntegerDivisionStep> steps,
                             int partialDividend,
                             int divisorMultiple,
                             char quotientDigit) {
        steps.add(new IntegerDivisionStep(partialDividend, divisorMultiple, quotientDigit));
    }

}
