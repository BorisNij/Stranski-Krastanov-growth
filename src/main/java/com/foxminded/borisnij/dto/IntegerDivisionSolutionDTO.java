package com.foxminded.borisnij.dto;

import com.foxminded.borisnij.formatter.IntegerDivisionSolutionFormatter;

import java.util.List;
import java.util.Objects;

public class IntegerDivisionSolutionDTO {
    private final String dividend;
    private final String divisor;
    private final String quotient;
    private final String firstDivisorMultiple;
    private final int firstPartialDividendLength;
    private final List<IntegerDivisionStepDTO> divisionSteps;

    public IntegerDivisionSolutionDTO(Builder builder) {
        this.dividend = builder.dividend;
        this.divisor = builder.divisor;
        this.quotient = builder.quotient;
        this.firstDivisorMultiple = builder.firstDivisorMultiple;
        this.firstPartialDividendLength = builder.firstPartialDividendLength;
        this.divisionSteps = builder.divisionSteps;
    }

    public static class Builder {

        private String dividend;
        private String divisor;
        private String quotient;
        private String firstDivisorMultiple;
        private int firstPartialDividendLength = -1;

        private List<IntegerDivisionStepDTO> divisionSteps;

        public Builder dividend(String dividend) {
            this.dividend = Objects.requireNonNull(dividend);
            return this;
        }

        public Builder divisor(String divisor) {
            this.divisor = Objects.requireNonNull(divisor);
            return this;
        }

        public Builder quotient(String quotient) {
            this.quotient = Objects.requireNonNull(quotient);
            return this;
        }

        public Builder firstDivisorMultiple(String firstDivisorMultiple) {
            this.firstDivisorMultiple = Objects.requireNonNull(firstDivisorMultiple);
            return this;
        }

        public Builder firstPartialDividendLength(int firstPartialDividendLength) {
            if (firstPartialDividendLength < 1) {
                throw new IllegalArgumentException(
                        "First partial dividend cannot have zero or negative number of digits");
            }
            this.firstPartialDividendLength = firstPartialDividendLength;
            return this;
        }

        public Builder divisionSteps(List<IntegerDivisionStepDTO> divisionSteps) {
            this.divisionSteps = Objects.requireNonNull(divisionSteps);
            return this;
        }

        public IntegerDivisionSolutionDTO build() {
            if (null == dividend ||
                    null == divisor ||
                    null == quotient ||
                    null == firstDivisorMultiple ||
                    this.firstPartialDividendLength == -1 ||
                    null == divisionSteps) {
                throw new IllegalStateException("Not all fields have been set to a valid value");
            }

            return new IntegerDivisionSolutionDTO(this);
        }


    }

    public String formatWithFormatter(IntegerDivisionSolutionFormatter solutionFormatter) {
        return solutionFormatter.format(this.dividend,
                                        this.divisor,
                                        this.quotient,
                                        this.firstDivisorMultiple,
                                        this.firstPartialDividendLength,
                                        this.divisionSteps);
    }

    public String getDividend() {
        return dividend;
    }

    public String getDivisor() {
        return divisor;
    }

    public String getQuotient() {
        return quotient;
    }

    public String getFirstDivisorMultiple() {
        return firstDivisorMultiple;
    }

    public int getFirstPartialDividendLength() {
        return firstPartialDividendLength;
    }

    public List<IntegerDivisionStepDTO> getDivisionSteps() {
        return divisionSteps;
    }
}
