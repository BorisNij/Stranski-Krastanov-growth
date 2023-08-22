package com.foxminded.borisnij;

import java.util.Objects;

public class IntegerDivisionStep {
    private final int partialDividend;
    private final int rightmostPartialDividendDigitIndex;
    private final int divisorMultiple;
    private final char quotientDigit;


    public IntegerDivisionStep(int partialDividend,
                               int divisorMultiple,
                               char quotientDigit,
                               int rightmostPartialDividendDigitIndex) {
        this.partialDividend = partialDividend;
        this.rightmostPartialDividendDigitIndex = rightmostPartialDividendDigitIndex;
        this.divisorMultiple = divisorMultiple;
        this.quotientDigit = quotientDigit;
    }

    public IntegerDivisionStep(int partialDividend, int divisorMultiple, char quotientDigit) {
        this(partialDividend, divisorMultiple, quotientDigit, -1);
    }

    public IntegerDivisionStep(IntegerDivisionStep other) {
        this(other.getPartialDividend(),
             other.getDivisorMultiple(),
             other.getQuotientDigit(),
             other.getRightmostPartialDividendDigitIndex());
    }

    public int getPartialDividend() {
        return partialDividend;
    }

    public int getDivisorMultiple() {
        return divisorMultiple;
    }

    public char getQuotientDigit() {
        return quotientDigit;
    }

    public int getRightmostPartialDividendDigitIndex() {
        return rightmostPartialDividendDigitIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerDivisionStep that = (IntegerDivisionStep) o;
        return partialDividend == that.partialDividend &&
                rightmostPartialDividendDigitIndex == that.rightmostPartialDividendDigitIndex &&
                divisorMultiple == that.divisorMultiple &&
                quotientDigit == that.quotientDigit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partialDividend, rightmostPartialDividendDigitIndex, divisorMultiple, quotientDigit);
    }

    @Override
    public String toString() {
        return String.format(
                "\n{partialDividend=%d,\nrightmostPartialDividendDigitIndex=%d\ndivisorMultiple=%d,\nquotientDigit='%c'}",
                partialDividend,
                rightmostPartialDividendDigitIndex,
                divisorMultiple,
                quotientDigit);
    }
}
