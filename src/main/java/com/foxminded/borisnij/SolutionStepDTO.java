package com.foxminded.borisnij;

public class SolutionStepDTO {
    private String partialDividend;
    private String divisorMultiple;

    public SolutionStepDTO(String partialDividend, String divisorMultiple) {
        this.partialDividend = partialDividend;
        this.divisorMultiple = divisorMultiple;
    }

    public String getPartialDividend() {
        return partialDividend;
    }

    public void setPartialDividend(String partialDividend) {
        this.partialDividend = partialDividend;
    }

    public String getDivisorMultiple() {
        return divisorMultiple;
    }

    public void setDivisorMultiple(String divisorMultiple) {
        this.divisorMultiple = divisorMultiple;
    }
}
