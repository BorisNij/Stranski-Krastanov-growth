package com.foxminded.borisnij.model;

import java.util.Objects;

public class IntegerDivisionStep {
    private final int partialDividend;
    private final int divisorMultiple;
    private final char quotientDigit;


    public IntegerDivisionStep(int partialDividend, int divisorMultiple, char quotientDigit) {
        this.partialDividend = partialDividend;
        this.divisorMultiple = divisorMultiple;
        this.quotientDigit = quotientDigit;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerDivisionStep that = (IntegerDivisionStep) o;
        return partialDividend == that.partialDividend &&
                divisorMultiple == that.divisorMultiple &&
                quotientDigit == that.quotientDigit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partialDividend, divisorMultiple, quotientDigit);
    }

    @Override
    public String toString() {
        return String.format("\n{partialDividend=%d\ndivisorMultiple=%d,\nquotientDigit='%c'}",
                             partialDividend,
                             divisorMultiple,
                             quotientDigit);
    }
}
