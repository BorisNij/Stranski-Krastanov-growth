package com.foxminded.borisnij;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerDivisionExerciseFormattingService {

    public String format(IntegerDivisionExercise divisionExercise) {
        String solutionHeader = createSolutionHeader(divisionExercise);
        String solutionBody = createSolutionBody(divisionExercise.getDivisionSteps());
        return String.join("\n", solutionHeader, solutionBody);
    }

    private String createSolutionHeader(IntegerDivisionExercise divisionExercise) {
        int dividend = divisionExercise.getDividend();
        int divisor = divisionExercise.getDivisor();
        String quotient = getQuotientFromSteps(divisionExercise.getDivisionSteps());
        String firstDivisorMultiple = getFirstDivisorMultipleFromSteps(divisionExercise.getDivisionSteps());
        int firstPartialDividend = divisionExercise.getDivisionSteps().get(0).getPartialDividend();
        String solutionOperandsLineTemplate = "_%1$d|%2$d";
        return String.join("\n",
                           String.format(solutionOperandsLineTemplate, dividend, divisor),
                           String.format(getDivisorMultipleLineTemplate(dividend, firstPartialDividend),
                                         firstDivisorMultiple) +
                                   getDivisorMultipleLineSuffix(dividend, firstPartialDividend, quotient),
                           String.format(getQuotientLineTemplate(dividend, firstPartialDividend), quotient));
    }

    private String getDivisorMultipleLineTemplate(int dividend, int partialDividend) {
        String divStr = String.valueOf(dividend);
        String partialDivStr = String.valueOf(partialDividend);
        return "%" + (partialDivStr.length() + 1) + "s";
    }

    private String getDivisorMultipleLineSuffix(int dividend, int partialDividend, String quotient) {
        return " ".repeat(String.valueOf(dividend).length() - String.valueOf(partialDividend).length()) +
                "|" +
                "-".repeat(quotient.length());
    }

    private String getQuotientLineTemplate(int dividend, int partialDividend) {
        String divStr = String.valueOf(dividend);
        String partialDivStr = String.valueOf(partialDividend);
        String rightPadding = " ".repeat(divStr.length() - partialDivStr.length());
        return String.format("%" + (partialDivStr.length() + 1) + "s", "-".repeat(partialDivStr.length())) +
                rightPadding +
                "|" +
                "%s";
    }

    private String getFirstDivisorMultipleFromSteps(List<IntegerDivisionStep> divisionSteps) {
        return String.valueOf(divisionSteps.get(0).getDivisorMultiple());
    }

    private String getQuotientFromSteps(List<IntegerDivisionStep> divisionSteps) {
        return IntStream.range(0, divisionSteps.size() - 1)
                .mapToObj(i -> String.valueOf(divisionSteps.get(i).getQuotientDigit()))
                .collect(Collectors.joining());
    }

    private String createSolutionBody(List<IntegerDivisionStep> divisionSteps) {
        final StringBuilder solutionBodyBuilder = new StringBuilder(divisionSteps.size());

        final int lastIndex = divisionSteps.size() - 1;
        for (int i = 1; i < lastIndex; i++) {
            final int lineLen = divisionSteps.get(i).getDividendLength();
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
                                                                 .getDividendLength()) +
                                                         "d", divisionSteps.get(lastIndex).getPartialDividend()));
        return solutionBodyBuilder.toString();
    }

    private String getPadding(char paddingChar, int count) {
        return String.valueOf(paddingChar).repeat(count > 0 ? count : 0);
    }


}
