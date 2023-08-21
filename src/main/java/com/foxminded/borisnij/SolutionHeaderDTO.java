package com.foxminded.borisnij;

public class SolutionHeaderDTO {
    private String dividend;
    private String divisor;
    private String divisorMultiple;
    private String quotient;

    public SolutionHeaderDTO(String dividend, String divisor, String divisorMultiple, String quotient) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.divisorMultiple = divisorMultiple;
        this.quotient = quotient;
    }

    public String getDividend() {
        return dividend;
    }

    public void setDividend(String dividend) {
        this.dividend = dividend;
    }

    public String getDivisor() {
        return divisor;
    }

    public void setDivisor(String divisor) {
        this.divisor = divisor;
    }

    public String getDivisorMultiple() {
        return divisorMultiple;
    }

    public void setDivisorMultiple(String divisorMultiple) {
        this.divisorMultiple = divisorMultiple;
    }

    public String getQuotient() {
        return quotient;
    }

    public void setQuotient(String quotient) {
        this.quotient = quotient;
    }
}
