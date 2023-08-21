package com.foxminded.borisnij;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerDivisionExercise {
    private int dividend;
    private int divisor;
    private final List<IntegerDivisionStep> divisionSteps;

    public IntegerDivisionExercise(int dividend, int divisor, List<IntegerDivisionStep> divisionSteps) {
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
}
