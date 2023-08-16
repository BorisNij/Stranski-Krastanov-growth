package com.foxminded.borisnij;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LongDividerTest {


    LongDivider longDivider;

    @BeforeEach
    void setUp() {
        longDivider = new LongDivider();
    }

    @Test
    void divide() {
        final List<DivisionStep> divisionSteps = longDivider.divide(125, 5);
    }
}
