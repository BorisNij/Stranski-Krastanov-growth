package net.bnijik.intDivApp.calculator;

import net.bnijik.intDivApp.model.IntegerDivisionStep;

import java.util.List;

public interface IntegerDivisionCalculator {
    List<IntegerDivisionStep> calculateDivisionStepsForOperands(int dividend, int divisor);
}
