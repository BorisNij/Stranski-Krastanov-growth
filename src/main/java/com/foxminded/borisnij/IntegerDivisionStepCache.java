package com.foxminded.borisnij;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerDivisionStepCache {
    private final Map<String, List<IntegerDivisionStep>> stepCache = new HashMap<>();

    public List<IntegerDivisionStep> getIntegerDivisionStepsForOperands(int dividend, int divisor) {
        return Collections.unmodifiableList(this.stepCache.getOrDefault(parseKey(dividend, divisor),
                                                                        Collections.emptyList()));
    }

    public void addIntegerDivisionStepsForOperands(int dividend,
                                                   int divisor,
                                                   List<IntegerDivisionStep> integerDivisionSteps) {
        this.stepCache.put(parseKey(dividend, divisor), integerDivisionSteps);
    }

    public boolean containsIntegerDivisionStepsForOperands(int dividend, int divisor) {
        return this.stepCache.containsKey(parseKey(dividend, divisor));
    }

    public boolean isEmpty() {
        return stepCache.isEmpty();
    }

    public void invalidate() {
        this.stepCache.clear();
    }

    private String parseKey(int dividend, int divisor) {
        return String.format("%1$d/%2$d", dividend, divisor);
    }
}
