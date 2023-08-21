package com.foxminded.borisnij;

import java.util.ArrayList;
import java.util.List;

//TODO: refactor by splitting into DivisionStepCalculationService and
// its subclass - CachingDivisionStepCalculationService
public class DivisionStepCalculationService {
    private final IntegerDivisionStepCache divisionStepCache;

    public DivisionStepCalculationService(IntegerDivisionStepCache divisionStepCache) {
        this.divisionStepCache = divisionStepCache;
    }

    public DivisionStepCalculationService() {
        this.divisionStepCache = null;
    }

    public List<IntegerDivisionStep> calculateStepsForOperands(int dividend, int divisor) {
        if (null == this.divisionStepCache) {
            return calculateSteps(dividend, divisor);
        }

        final List<IntegerDivisionStep> steps = this.divisionStepCache.getIntegerDivisionStepsForOperands(
                dividend,
                divisor);

        if (steps.isEmpty()) {
            final List<IntegerDivisionStep> integerDivisionSteps = calculateSteps(dividend, divisor);
            this.divisionStepCache.addIntegerDivisionStepsForOperands(dividend, divisor, integerDivisionSteps);
            return integerDivisionSteps;
        }

        return steps;
    }

    private List<IntegerDivisionStep> calculateSteps(int dividend, int divisor) {
        if (divisor < 1) {
            throw new IllegalArgumentException("Negative or zero divisor not allowed");
        }

        if (dividend < 0) {
            throw new IllegalArgumentException("Negative dividend not allowed");
        }

        List<IntegerDivisionStep> steps = new ArrayList<>();

        if (dividend == 0) {
            updateSteps(steps, 0, 0, '0');
            updateSteps(steps, 1, 0, '\0');
            return steps;
        }

        String dividendStr = String.valueOf(dividend);
        int partialDividend = 0;

        for (int i = 0; i < dividendStr.length(); i++) {
            int dividendDigit = Character.getNumericValue(dividendStr.charAt(i));
            partialDividend = (partialDividend << 3) + (partialDividend << 1) + dividendDigit;

            if (partialDividend >= divisor) {
                int quotientDigit = partialDividend / divisor;
                int divisorMultiple = quotientDigit * divisor;
                updateSteps(steps, partialDividend, divisorMultiple, Character.forDigit(quotientDigit, 10), i);

                partialDividend -= divisorMultiple;
            } else if (!steps.isEmpty()) {
                updateSteps(steps, partialDividend, 0, Character.forDigit(0, 10), i);
            }
        }

        updateSteps(steps, partialDividend, 0, '\0');
        return steps;
    }

    private void updateSteps(List<IntegerDivisionStep> steps,
                             int partialDividend,
                             int divisorMultiple,
                             char quotientDigit) {
        updateSteps(steps, partialDividend, divisorMultiple, quotientDigit, -1);
    }

    private void updateSteps(List<IntegerDivisionStep> steps,
                             int partialDividend,
                             int divisorMultiple,
                             char quotientDigit,
                             int rightmostPartialDividendDigitIndex) {
        steps.add(new IntegerDivisionStep(partialDividend,
                                          divisorMultiple,
                                          quotientDigit,
                                          rightmostPartialDividendDigitIndex));
    }
}
