package com.foxminded.borisnij;

import java.util.Objects;

public class IntegerDivisionStep {
    private final int partialDividend;
    private final int dividendLength;
    private final int divisorMultiple;
    private final char quotientDigit;


    public IntegerDivisionStep(int partialDividend,
                               int divisorMultiple,
                               char quotientDigit,
                               int rightmostPartialDividendDigitIndex) {
        this.partialDividend = partialDividend;
        this.dividendLength = rightmostPartialDividendDigitIndex + 1;
        this.divisorMultiple = divisorMultiple;
        this.quotientDigit = quotientDigit;
    }

    public IntegerDivisionStep(IntegerDivisionStep other) {
        this(other.getPartialDividend(),
             other.getDivisorMultiple(),
             other.getQuotientDigit(),
             other.getDividendLength());
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

    public int getDividendLength() {
        return dividendLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerDivisionStep that = (IntegerDivisionStep) o;
        return partialDividend == that.partialDividend &&
                dividendLength == that.dividendLength &&
                divisorMultiple == that.divisorMultiple &&
                quotientDigit == that.quotientDigit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partialDividend, dividendLength, divisorMultiple, quotientDigit);
    }

    @Override
    public String toString() {
        return String.format(
                "\n{partialDividend=%d,\nrightmostPartialDividendDigitIndex=%d\ndivisorMultiple=%d,\nquotientDigit='%c'}",
                partialDividend,
                dividendLength,
                divisorMultiple,
                quotientDigit);
    }
}
