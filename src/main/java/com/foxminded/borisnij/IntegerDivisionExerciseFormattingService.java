package com.foxminded.borisnij;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerDivisionExerciseFormattingService {

    public String format(IntegerDivisionExercise divisionExercise) {
        final String dividend = String.valueOf(divisionExercise.getDividend());
        final String divisor = String.valueOf(divisionExercise.getDivisor());
        final List<IntegerDivisionStep> divisionSteps = divisionExercise.getDivisionSteps();
        final String solutionHeader = format(dividend, divisor, divisionSteps);
        final String solutionBody = format(divisionSteps);
        return String.join("\n", solutionHeader, solutionBody);
    }

    private String format(String dividend, String divisor, List<IntegerDivisionStep> divisionSteps) {
        final String quotient = getQuotientFromSteps(divisionSteps);
        final String firstDivisorMultiple = getFirstDivisorMultipleFromSteps(divisionSteps);
        final String solutionHeaderFirstLineTemplate = "_%1$s|%2$s";
        final int firstPartialDividendLength = divisionSteps.get(0).getRightmostPartialDividendDigitIndex() + 1;
        final String divisorMultipleTemplate = "%1$" + (firstPartialDividendLength + 1) + "s";
        final String rightPadding = getPadding(' ', dividend.length() - firstPartialDividendLength);
        final String divisorQuotientRuler = "-".repeat(quotient.length());
        final String solutionHeaderSecondLineTemplate = divisorMultipleTemplate + rightPadding + "|" + "%2$s";
        final String subtractionResultRuler = "-".repeat(firstPartialDividendLength);
        final String solutionHeaderThirdLineTemplate = "%1$" +
                (firstPartialDividendLength + 1) +
                "s" +
                rightPadding +
                "|" +
                "%2$s";
        return String.join("\n",
                           String.format(solutionHeaderFirstLineTemplate, dividend, divisor),
                           String.format(solutionHeaderSecondLineTemplate, firstDivisorMultiple, divisorQuotientRuler),
                           String.format(solutionHeaderThirdLineTemplate, subtractionResultRuler, quotient));
    }

    private String getFirstDivisorMultipleFromSteps(List<IntegerDivisionStep> divisionSteps) {
        return String.valueOf(divisionSteps.get(0).getDivisorMultiple());
    }

    private String getQuotientFromSteps(List<IntegerDivisionStep> divisionSteps) {
        return IntStream.range(0, divisionSteps.size() - 1)
                .mapToObj(i -> String.valueOf(divisionSteps.get(i).getQuotientDigit()))
                .collect(Collectors.joining());
    }

    private String format(List<IntegerDivisionStep> divisionSteps) {
        final StringBuilder solutionBodyBuilder = new StringBuilder(divisionSteps.size());

        final int lastIndex = divisionSteps.size() - 1;
        for (int i = 1; i < lastIndex; i++) {
            final int lineLen = divisionSteps.get(i).getRightmostPartialDividendDigitIndex() + 2;
            final IntegerDivisionStep step = divisionSteps.get(i);
            solutionBodyBuilder.append(String.format("%" + lineLen + "s", "_" + step.getPartialDividend()))
                    .append("\n")
                    .append(String.format("%" + lineLen + "s", step.getDivisorMultiple()))
                    .append("\n")
                    .append(String.format("%" + lineLen + "s",
                                          "-".repeat(String.valueOf(step.getPartialDividend()).length())))
                    .append("\n");

        }
        solutionBodyBuilder.append(String.format("%" +
                                                         (divisionSteps.get(lastIndex)
                                                                 .getRightmostPartialDividendDigitIndex() + 2) +
                                                         "d", divisionSteps.get(lastIndex).getPartialDividend()));
        return solutionBodyBuilder.toString();
    }

    private String getPadding(char paddingChar, int count) {
        return String.valueOf(paddingChar).repeat(count);
    }


}
