package com.foxminded.borisnij;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IntegerDivisionSolution {
    private int dividend;
    private int divisor;
    private final List<IntegerDivisionStep> divisionSteps;

    public IntegerDivisionSolution(int dividend, int divisor, List<IntegerDivisionStep> divisionSteps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.divisionSteps = new ArrayList<>();

        divisionSteps.stream().map(IntegerDivisionStep::new).forEach(this.divisionSteps::add);
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public List<IntegerDivisionStep> getDivisionSteps() {
        return Collections.unmodifiableList(this.divisionSteps);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerDivisionSolution that = (IntegerDivisionSolution) o;
        return dividend == that.dividend &&
                divisor == that.divisor &&
                Objects.equals(divisionSteps, that.divisionSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, divisionSteps);
    }

    @Override
    public String toString() {
        return "IntegerDivisionSolution{" +
                "dividend=" + dividend +
                ", divisor=" + divisor +
                ", divisionSteps=" + divisionSteps +
                '}';
    }
}
