package net.bnijik.intDivApp.calculator;

import net.bnijik.intDivApp.model.IntegerDivisionStep;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerDivisionStepCacheImpl implements IntegerDivisionStepCache {
    private final Map<String, List<IntegerDivisionStep>> stepCache = new HashMap<>();

    @Override
    public List<IntegerDivisionStep> getIntegerDivisionStepsForOperands(int dividend, int divisor) {
        return Collections.unmodifiableList(this.stepCache.getOrDefault(parseKey(dividend, divisor),
                                                                        Collections.emptyList()));
    }

    @Override
    public void addIntegerDivisionStepsForOperands(int dividend,
                                                   int divisor,
                                                   List<IntegerDivisionStep> integerDivisionSteps) {
        this.stepCache.put(parseKey(dividend, divisor), integerDivisionSteps);
    }

    @Override
    public boolean containsIntegerDivisionStepsForOperands(int dividend, int divisor) {
        return this.stepCache.containsKey(parseKey(dividend, divisor));
    }

    @Override
    public boolean isEmpty() {
        return stepCache.isEmpty();
    }

    @Override
    public void invalidate() {
        this.stepCache.clear();
    }

    private String parseKey(int dividend, int divisor) {
        return String.format("%1$d/%2$d", dividend, divisor);
    }
}
