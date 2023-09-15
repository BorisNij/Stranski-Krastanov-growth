package com.foxminded.borisnij;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerDivisionStepDTO)) return false;
        IntegerDivisionStepDTO that = (IntegerDivisionStepDTO) o;
        return Objects.equals(partialDividend, that.partialDividend) &&
                Objects.equals(divisorMultiple, that.divisorMultiple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partialDividend, divisorMultiple);
    }
}
