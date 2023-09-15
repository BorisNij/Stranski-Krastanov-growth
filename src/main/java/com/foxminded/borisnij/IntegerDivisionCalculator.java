package com.foxminded.borisnij;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerDivisionCalculator {


    private static void updateSteps(List<IntegerDivisionStep> steps,
                                    int partialDividend,
                                    int divisorMultiple,
                                    char quotientDigit) {
        steps.add(new IntegerDivisionStep(partialDividend, divisorMultiple, quotientDigit));
    }

    private static int findHighestDecimalPositionMultiplier(int integer) {
        int highestDecimalPositionMultiplier = 1;

        if (integer >= 1_000_000) {
            highestDecimalPositionMultiplier = 1_000_000;
        } else if (integer >= 100_000) {
            highestDecimalPositionMultiplier = 100_000;
        } else if (integer >= 10_000) {
            highestDecimalPositionMultiplier = 10_000;
        } else if (integer >= 1_000) {
            highestDecimalPositionMultiplier = 1_000;
        } else if (integer >= 100) {
            highestDecimalPositionMultiplier = 100;
        } else if (integer >= 10) {
            highestDecimalPositionMultiplier = 10;
        }

        return highestDecimalPositionMultiplier;
    }

    private static int extractMostSignificantDigit(int integer, int decimalPositionMultiplier) {
        return integer / decimalPositionMultiplier;
    }

    private static int calculateNextPartialDividend(int partialDividend, int dividendDigit) {
        return (partialDividend << 3) + (partialDividend << 1) + dividendDigit;
    }

    private static char quotientDigitToChar(int quotientDigit) {
        final char quotientChar = Character.forDigit(quotientDigit, 10);
        if ('\0' == quotientChar) {
            throw new IllegalArgumentException("Digit cannot be negative or higher than 9");
        }
        return quotientChar;
    }

    private static int removeMostSignificantDigit(int integer, int decimalPositionMultiplier) {
        return integer % decimalPositionMultiplier;
    }

    public List<IntegerDivisionStep> calculateDivisionStepsForOperands(int dividend, int divisor) {
        if (divisor < 1) {
            throw new IllegalArgumentException("Negative or zero divisor not allowed");
        }

        if (dividend < 0) {
            throw new IllegalArgumentException("Negative dividend not allowed");
        }

        if (dividend == 0) {
            List<IntegerDivisionStep> steps = new ArrayList<>(2);
            updateSteps(steps, 0, 0, '0');
            updateSteps(steps, 0, 0, '\0');
            return Collections.unmodifiableList(steps);
        }

        if (dividend < divisor) {
            List<IntegerDivisionStep> steps = new ArrayList<>(2);
            updateSteps(steps, dividend, 0, '0');
            updateSteps(steps, dividend, 0, '\0');
            return Collections.unmodifiableList(steps);
        }

        List<IntegerDivisionStep> steps = new ArrayList<>();
        int positionMultiplier = findHighestDecimalPositionMultiplier(dividend);
        int partialDividend = 0;
        while (positionMultiplier > 0) {
            int dividendDigit = extractMostSignificantDigit(dividend, positionMultiplier);
            partialDividend = calculateNextPartialDividend(partialDividend, dividendDigit);

            if (partialDividend >= divisor) {
                int quotientDigit = partialDividend / divisor;
                int divisorMultiple = quotientDigit * divisor;
                updateSteps(steps, partialDividend, divisorMultiple, quotientDigitToChar(quotientDigit));

                partialDividend -= divisorMultiple;
            } else if (!steps.isEmpty()) {
                updateSteps(steps, partialDividend, 0, quotientDigitToChar(0));
            }
            dividend = removeMostSignificantDigit(dividend, positionMultiplier);
            positionMultiplier /= 10;
        }

        updateSteps(steps, partialDividend, 0, '\0');
        return Collections.unmodifiableList(steps);
    }
}
