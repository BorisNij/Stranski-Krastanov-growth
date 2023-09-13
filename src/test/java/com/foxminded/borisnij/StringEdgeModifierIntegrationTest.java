package com.foxminded.borisnij;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringEdgeModifierIntegrationTest {

    StringEdgeModifier stringEdgeModifier;

    @BeforeEach
    void setup() {
        stringEdgeModifier = new StringEdgeModifier();
    }

    @Test
    @DisplayName("when chaining operations should produce expected result")
    void whenChainingOperationsShouldProduceExpectedResult() {
        stringEdgeModifier.setValue("InitialValue").addPrefix("Prefix1").addSuffix("Suffix1");

        assertEquals("Prefix1InitialValueSuffix1", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when chaining with empty string should produce expected result")
    void whenChainingWithEmptyStringShouldProduceExpectedResult() {
        stringEdgeModifier.addPrefix("Prefix").addSuffix("Suffix");

        assertEquals("PrefixSuffix", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when chaining with null should produce expected result")
    void whenChainingWithNullShouldProduceExpectedResult() {
        stringEdgeModifier = new StringEdgeModifier(null);

        stringEdgeModifier.setValue("Value").addPrefix("Prefix");

        assertEquals("PrefixValue", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when chaining with negative repeat should throw IllegalArgumentException")
    void whenChainingWithNegativeRepeatShouldThrowIllegalArgumentException() {
        stringEdgeModifier = new StringEdgeModifier("Value");

        assertThrows(IllegalArgumentException.class, () -> stringEdgeModifier.addPrefix("Prefix", -1));

        assertThrows(IllegalArgumentException.class, () -> stringEdgeModifier.addSuffix("Suffix", -1));
    }

    @Test
    @DisplayName("when chaining with long strings should produce expected result")
    void whenChainingWithLongStringsShouldProduceExpectedResult() {
        stringEdgeModifier.setValue("ThisIsALongString").addPrefix("Prefix1").addSuffix("Suffix1");

        assertEquals("Prefix1ThisIsALongStringSuffix1", stringEdgeModifier.toString());
    }
}
