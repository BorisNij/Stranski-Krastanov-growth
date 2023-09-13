package com.foxminded.borisnij;

public class IntegerDivisionStepDTO {
    private final String partialDividend;
    private final String divisorMultiple;

    public IntegerDivisionStepDTO(String partialDividend, String divisorMultiple) {
        this.partialDividend = partialDividend;
        this.divisorMultiple = divisorMultiple;
    }

    public String getPartialDividend() {
        return partialDividend;
    }

    public String getDivisorMultiple() {
        return divisorMultiple;
    }
}
