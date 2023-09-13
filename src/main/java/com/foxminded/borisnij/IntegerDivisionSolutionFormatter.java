package com.foxminded.borisnij;

import java.util.List;
import java.util.StringJoiner;

public class IntegerDivisionSolutionFormatter {

    private final StringEdgeModifier edgeModifier;

    public IntegerDivisionSolutionFormatter(StringEdgeModifier edgeModifier) {
        this.edgeModifier = edgeModifier;
    }

    public String format(String dividend,
                         String divisor,
                         String quotient,
                         String firstDivisorMultiple,
                         int firstPartialDividendLength,
                         List<IntegerDivisionStepDTO> divisionSteps) {

        String solutionHead = formatHead(dividend, divisor, quotient, firstDivisorMultiple, firstPartialDividendLength);


        String solutionBody = formatBody(firstPartialDividendLength, divisionSteps);

        return String.join("\n", solutionHead, solutionBody);
    }

    private String formatHead(String dividend,
                              String divisor,
                              String quotient,
                              String firstDivisorMultiple,
                              int firstPartialDividendLength) {
        String operandsLine = String.join("", "_", dividend, "|", divisor);
        String rightPadding = " ".repeat(dividend.length() - firstPartialDividendLength);
        String firstDivisorMultipleLine = String.join("|",
                                                      edgeModifier.setValue(firstDivisorMultiple)
                                                              .addPrefix(" ")
                                                              .addSuffix(rightPadding),
                                                      "-".repeat(quotient.length()));
        String quotientLine = String.join("|",
                                          edgeModifier.setValue("-".repeat(firstPartialDividendLength))
                                                  .addPrefix(" ")
                                                  .addSuffix(rightPadding),
                                          quotient);

        return String.join("\n", operandsLine, firstDivisorMultipleLine, quotientLine);
    }

    private String formatBody(int firstPartialDividendLength, List<IntegerDivisionStepDTO> divisionSteps) {
        StringJoiner solutionBodyJoiner = new StringJoiner("\n");
        final int lastIndex = divisionSteps.size() - 1;
        for (int i = 0; i < lastIndex; i++) {
            final IntegerDivisionStepDTO step = divisionSteps.get(i);
            final String stepPartialDividend = step.getPartialDividend();
            final int stepPaddingLength = (firstPartialDividendLength + i + 2) - stepPartialDividend.length();
            appendSolutionLine(stepPaddingLength, step, solutionBodyJoiner);
        }
        appendSolutionLine((lastIndex + firstPartialDividendLength + 1) -
                                   divisionSteps.get(lastIndex).getPartialDividend().length(),
                           divisionSteps.get(lastIndex).getPartialDividend(),
                           solutionBodyJoiner);
        return solutionBodyJoiner.toString();
    }

    private void appendSolutionLine(int leftPaddingLength,
                                    IntegerDivisionStepDTO step,
                                    StringJoiner solutionBodyJoiner) {
        final String partialDividend = step.getPartialDividend();
        solutionBodyJoiner.add(edgeModifier.setValue(partialDividend)
                                       .addPrefix("_")
                                       .addPrefix(" ", leftPaddingLength - 1))
                .add(edgeModifier.setValue(step.getDivisorMultiple()).addPrefix(" ", leftPaddingLength))
                .add(edgeModifier.setValue("-".repeat(partialDividend.length())).addPrefix(" ", leftPaddingLength));
    }

    private void appendSolutionLine(int leftPaddingLength, String remainder, StringJoiner solutionBodyJoiner) {
        solutionBodyJoiner.add(edgeModifier.setValue(remainder).addPrefix(" ", leftPaddingLength));
    }
}
