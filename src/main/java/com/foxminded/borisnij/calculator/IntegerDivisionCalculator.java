package com.foxminded.borisnij.calculator;

import com.foxminded.borisnij.model.IntegerDivisionStep;

import java.util.List;

public interface IntegerDivisionCalculator {
    List<IntegerDivisionStep> calculateDivisionStepsForOperands(int dividend, int divisor);
}
