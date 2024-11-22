package net.bnijik.intDivApp.calculator;

import net.bnijik.intDivApp.model.IntegerDivisionStep;

import java.util.List;

public interface IntegerDivisionStepCache {
    List<IntegerDivisionStep> getIntegerDivisionStepsForOperands(int dividend, int divisor);

    void addIntegerDivisionStepsForOperands(int dividend,
                                            int divisor,
                                            List<IntegerDivisionStep> integerDivisionSteps);

    boolean containsIntegerDivisionStepsForOperands(int dividend, int divisor);

    boolean isEmpty();

    void invalidate();
}
