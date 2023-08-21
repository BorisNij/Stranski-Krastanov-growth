package com.foxminded.borisnij.solutionString;

public class BodySolutionString implements Formattable {
    private String partialDividend;
    private String divisorMultiple;

    public BodySolutionString(String partialDividend, String divisorMultiple) {
        this.partialDividend = partialDividend;
        this.divisorMultiple = divisorMultiple;
    }

    @Override
    public String format() {
        return null;
    }

    public String getPartialDividend() {
        return partialDividend;
    }

    public String getDivisorMultiple() {
        return divisorMultiple;
    }
}
