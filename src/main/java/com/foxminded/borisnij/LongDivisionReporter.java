package com.foxminded.borisnij;

import java.util.List;

public class LongDivisionReporter {

    private static String getLeftPadding(String partialDividendStr, String divisorMultipleStr) {
        return " ".repeat(partialDividendStr.length() - divisorMultipleStr.length() + 1);
    }

    private static String getRightPadding(int dividend, String partialDividendStr) {
        final String dividendStr = String.valueOf(dividend);
        final String secondLineFormat = "%" + (partialDividendStr.length() + 1) + "d" + "%" + (dividendStr.length() - partialDividendStr.length()) + "s";
//                divisionSolution.append(String.format(secondLineFormat,
//                                                      divisionStep.getDivisorMultiple(),
//                                                      "|" + "-".repeat(quotientLength))).append("\n");
        final String rightPadding = " ".repeat(dividendStr.length() - partialDividendStr.length());
        return rightPadding;
    }

    public void report(int dividend, int divisor, List<DivisionStep> divisionSteps) {
        final StringBuilder divisionSolution = new StringBuilder();
        divisionSolution.append("_").append(dividend).append("|").append(divisor).append("\n");

        final int quotientLength = divisionSteps.size() - 1;
        final StringBuilder quotient = new StringBuilder(quotientLength);
        divisionSteps.stream().map(DivisionStep::getQuotientDigit).limit(quotientLength).forEach(quotient::append);

        StringBuilder nextLeftPadding = new StringBuilder(String.valueOf(dividend).length());
        for (int i = 0; i < divisionSteps.size(); i++) {
            final DivisionStep divisionStep = divisionSteps.get(i);
            final String partialDividendStr = String.valueOf(divisionStep.getPartialDividend());
            final String divisorMultipleStr = String.valueOf(divisionStep.getDivisorMultiple());

            if (i == 0) {
                final String rightPadding = getRightPadding(dividend, partialDividendStr);
                final String leftPadding = getLeftPadding(partialDividendStr, divisorMultipleStr);
                divisionSolution.append(leftPadding)
                        .append(divisionStep.getDivisorMultiple())
                        .append(rightPadding)
                        .append("|")
                        .append("-".repeat(quotientLength))
                        .append("\n");
                divisionSolution.append(leftPadding)
                        .append("-".repeat(divisorMultipleStr.length()))
                        .append(rightPadding)
                        .append("|")
                        .append(quotient)
                        .append("\n");
                nextLeftPadding.append(leftPadding)
                        .append(" ".repeat(divisorMultipleStr.length()))
                        .setLength(nextLeftPadding.length() - 2);
            } else if (divisionStep.getQuotientDigit() == '\0') {
                divisionSolution.append(nextLeftPadding)
                        .append(divisionStep.getPartialDividend());
            } else {
                divisionSolution.append(nextLeftPadding)
                        .append("_")
                        .append(divisionStep.getPartialDividend())
                        .append("\n");
                divisionSolution.append(nextLeftPadding)
                        .append(" ")
                        .append(divisionStep.getDivisorMultiple())
                        .append("\n");
                divisionSolution.append(nextLeftPadding)
                        .append(" ")
                        .append("-".repeat(divisorMultipleStr.length()))
                        .append("\n");
                nextLeftPadding.append(" ".repeat(divisorMultipleStr.length()));
            }
        }
        if (divisionSteps.size() == 1) {
            divisionSolution.append(" ").append(divisionSteps.get(0).getPartialDividend());
        }
        System.out.println(divisionSolution);
    }
}
