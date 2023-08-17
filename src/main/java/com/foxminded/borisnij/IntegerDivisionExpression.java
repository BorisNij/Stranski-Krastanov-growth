package com.foxminded.borisnij;

import java.util.Collections;
import java.util.List;

public class IntegerDivisionExpression {
    private int dividend;
    private int divisor;
    private IntegerDivider integerDivider;

    public IntegerDivisionExpression(int dividend, int divisor, IntegerDivider integerDivider) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.integerDivider = integerDivider;
    }

    public List<IntegerDivisionStep> getDivisionSteps() {
        return Collections.unmodifiableList(this.integerDivider.divide(this.dividend, this.divisor));
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public IntegerDivider getIntegerDivider() {
        return integerDivider;
    }

    public void setIntegerDivider(IntegerDivider integerDivider) {
        this.integerDivider = integerDivider;
    }
}
