package com.foxminded.borisnij;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerDivisionStepCache {
    private final Map<String, List<IntegerDivisionStep>> stepCache = new HashMap<>();

    public List<IntegerDivisionStep> getIntegerDivisionStepsForOperands(int dividend, int divisor) {
        return this.stepCache.getOrDefault(String.format("%1$d/%2$d", dividend, divisor), Collections.emptyList());
    }

    public void addIntegerDivisionStepsForOperands(int dividend,
                                                   int divisor,
                                                   List<IntegerDivisionStep> integerDivisionSteps) {
        this.stepCache.put(String.format("%1$d/%2$d", dividend, divisor), integerDivisionSteps);
    }

    public void invalidate() {
        this.stepCache.clear();
    }
}
