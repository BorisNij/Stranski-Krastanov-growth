package com.foxminded.borisnij;

import java.util.List;

public class IntegerDivisionFormatter {
    private String formattedSolution = "";


    private String getLeftPadding(String partialDividendStr, String divisorMultipleStr) {
        return " ".repeat(partialDividendStr.length() - divisorMultipleStr.length() + 1);
    }

    private String getRightPadding(int dividend, String partialDividendStr) {
        return " ".repeat(java.lang.String.valueOf(dividend).length() - partialDividendStr.length());
    }

    public String format(IntegerDivisionExpression integerDivisionExpression) {
        if (formattedSolution.length() != 0) {
            return formattedSolution;
        }
        final int dividend = integerDivisionExpression.getDividend();
        final int divisor = integerDivisionExpression.getDivisor();
        final List<IntegerDivisionStep> integerDivisionSteps = integerDivisionExpression.getDivisionSteps();

        final StringBuilder divisionSolution = new StringBuilder();
        divisionSolution.append("_").append(dividend).append("|").append(divisor).append("\n");

        final int quotientLength = integerDivisionSteps.size() - 1;
        final StringBuilder quotient = new StringBuilder(quotientLength);
        integerDivisionSteps.stream()
                .map(IntegerDivisionStep::getQuotientDigit)
                .limit(quotientLength)
                .forEach(quotient::append);

        StringBuilder nextLeftPadding = new StringBuilder(String.valueOf(dividend).length());
        for (int i = 0; i < integerDivisionSteps.size(); i++) {
            final IntegerDivisionStep integerDivisionStep = integerDivisionSteps.get(i);
            final String partialDividendStr = String.valueOf(integerDivisionStep.getPartialDividend());
            final String divisorMultipleStr = String.valueOf(integerDivisionStep.getDivisorMultiple());

            if (i == 0) {
                final String rightPadding = getRightPadding(dividend, partialDividendStr);
                final String leftPadding = getLeftPadding(partialDividendStr, divisorMultipleStr);
                divisionSolution.append(leftPadding)
                        .append(integerDivisionStep.getDivisorMultiple())
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
            } else if (integerDivisionStep.getQuotientDigit() == '\0') {
                divisionSolution.append(nextLeftPadding)
                        .append(integerDivisionStep.getPartialDividend());
            } else {
                divisionSolution.append(nextLeftPadding)
                        .append("_")
                        .append(integerDivisionStep.getPartialDividend())
                        .append("\n");
                divisionSolution.append(nextLeftPadding)
                        .append(" ")
                        .append(integerDivisionStep.getDivisorMultiple())
                        .append("\n");
                divisionSolution.append(nextLeftPadding)
                        .append(" ")
                        .append("-".repeat(divisorMultipleStr.length()))
                        .append("\n");
                nextLeftPadding.append(" ".repeat(divisorMultipleStr.length()));
            }
        }
        if (integerDivisionSteps.size() == 1) {
            divisionSolution.append(" ").append(integerDivisionSteps.get(0).getPartialDividend());
        }
        this.formattedSolution = divisionSolution.toString();
        return divisionSolution.toString();
    }
}
