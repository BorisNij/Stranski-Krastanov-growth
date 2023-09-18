package com.foxminded.borisnij.formatter;

import com.foxminded.borisnij.dto.IntegerDivisionStepDTO;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class IntegerDivisionSolutionFormatterImpl implements IntegerDivisionSolutionFormatter {
    private String verticalSeparator;
    private String horizontalSeparator;
    private char paddingSymbol;
    private String subtractionSign;

    public IntegerDivisionSolutionFormatterImpl(Builder builder) {
        this.verticalSeparator = builder.verticalSeparator;
        this.horizontalSeparator = builder.horizontalSeparator;
        this.paddingSymbol = builder.paddingSymbol;
        this.subtractionSign = builder.subtractionSign;
    }

    private static String charToString(char c) {
        return String.valueOf(c);
    }

    private static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String getVerticalSeparator() {
        return verticalSeparator;
    }

    public void setVerticalSeparator(String verticalSeparator) {
        this.verticalSeparator = Objects.requireNonNull(verticalSeparator);
    }

    public String getHorizontalSeparator() {
        return horizontalSeparator;
    }

    public void setHorizontalSeparator(String horizontalSeparator) {
        this.horizontalSeparator = Objects.requireNonNull(horizontalSeparator);
    }

    public char getPaddingSymbol() {
        return paddingSymbol;
    }

    public void setPaddingSymbol(char paddingSymbol) {
        this.paddingSymbol = paddingSymbol;
    }

    public String getSubtractionSign() {
        return subtractionSign;
    }

    public void setSubtractionSign(String subtractionSign) {
        this.subtractionSign = Objects.requireNonNull(subtractionSign);
    }

    @Override
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
        String operandsLine = String.join("", subtractionSign, dividend, verticalSeparator, divisor);
        String rightPadding = repeatChar(paddingSymbol, dividend.length() - firstPartialDividendLength);
        String firstDivisorMultipleLine = String.join("",
                                                      charToString(paddingSymbol),
                                                      firstDivisorMultiple,
                                                      rightPadding,
                                                      verticalSeparator,
                                                      horizontalSeparator.repeat(quotient.length()));
        String quotientLine = String.join("",
                                          charToString(paddingSymbol),
                                          horizontalSeparator.repeat(firstPartialDividendLength),
                                          rightPadding,
                                          verticalSeparator,
                                          quotient);

        return String.join("\n", operandsLine, firstDivisorMultipleLine, quotientLine);
    }

    private String formatBody(int firstPartialDividendLength, List<IntegerDivisionStepDTO> divisionSteps) {
        StringJoiner solutionBodyJoiner = new StringJoiner("\n");
        final int lastIndex = divisionSteps.size() - 1;
        for (int i = 0; i < lastIndex; i++) {
            final IntegerDivisionStepDTO step = divisionSteps.get(i);
            final String stepPartialDividend = step.getPartialDividend();
            final String stepDivisorMultiple = step.getDivisorMultiple();
            final int stepPaddingWidth = (firstPartialDividendLength + i + 2) - stepPartialDividend.length();
            appendSolutionLine(solutionBodyJoiner,
                               repeatChar(paddingSymbol, stepPaddingWidth - 1),
                               subtractionSign,
                               stepPartialDividend);
            appendSolutionLine(solutionBodyJoiner,
                               repeatChar(paddingSymbol,
                                          stepPaddingWidth +
                                                  (stepPartialDividend.length() - stepDivisorMultiple.length())),
                               stepDivisorMultiple);
            appendSolutionLine(solutionBodyJoiner,
                               repeatChar(paddingSymbol, stepPaddingWidth),
                               horizontalSeparator.repeat(stepPartialDividend.length()));
        }
        final String remainder = divisionSteps.get(lastIndex).getPartialDividend();
        final int leftPaddingWidth = Math.max(subtractionSign.length(),
                                              (lastIndex + firstPartialDividendLength + 1) - remainder.length());
        appendSolutionLine(solutionBodyJoiner, repeatChar(paddingSymbol, leftPaddingWidth), remainder);
        return solutionBodyJoiner.toString();
    }

    private void appendSolutionLine(StringJoiner solutionBodyJoiner, String... tokens) {
        solutionBodyJoiner.add(String.join("", tokens));
    }

    public static class Builder {
        private String verticalSeparator = "|";
        private String horizontalSeparator = "-";
        private char paddingSymbol = ' ';
        private String subtractionSign = "_";

        public Builder verticalSeparator(String verticalSeparator) {
            this.verticalSeparator = Objects.requireNonNull(verticalSeparator);
            return this;
        }

        public Builder horizontalSeparator(String horizontalSeparator) {
            this.horizontalSeparator = Objects.requireNonNull(horizontalSeparator);
            return this;
        }

        public Builder paddingSymbol(char paddingSymbol) {
            this.paddingSymbol = paddingSymbol;
            return this;
        }

        public Builder subtractionSign(String subtractionSign) {
            this.subtractionSign = Objects.requireNonNull(subtractionSign);
            return this;
        }

        public IntegerDivisionSolutionFormatter build() {
            return new IntegerDivisionSolutionFormatterImpl(this);
        }
    }
}
