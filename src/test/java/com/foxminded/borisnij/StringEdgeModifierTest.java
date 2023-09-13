package com.foxminded.borisnij;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringEdgeModifierTest {

    private StringEdgeModifier stringEdgeModifier;

    @BeforeEach
    void setUp() {
        stringEdgeModifier = new StringEdgeModifier();
    }

    @Test
    void testDefaultConstructor() {
        assertEquals("", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when constructed with string should return provided string")
    void whenConstructedWithStringShouldReturnProvidedString() {
        stringEdgeModifier = new StringEdgeModifier("Hello, World!");
        assertEquals("Hello, World!", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when value is set should return the set value")
    void whenValueIsSetShouldReturnTheSetValue() {
        stringEdgeModifier.setValue("TestValue");
        assertEquals("TestValue", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when prefix is added to empty initial string should return prefix")
    void whenPrefixIsAddedToEmptyInitialStringShouldReturnPrefix() {
        stringEdgeModifier.addPrefix("Prefix");
        assertEquals("Prefix", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when prefix repeat is provided prefix should repeat provided number of times")
    void whenPrefixRepeatIsProvidedPrefixShouldRepeatProvidedNumberOfTimes() {
        stringEdgeModifier.setValue("Value");
        stringEdgeModifier.addPrefix("Prefix", 3);
        assertEquals("PrefixPrefixPrefixValue", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when suffix is added to empty initial string should return suffix")
    void whenSuffixIsAddedToEmptyInitialStringShouldReturnSuffix() {
        stringEdgeModifier.addSuffix("Suffix");
        assertEquals("Suffix", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when suffix repeat is provided should repeat suffix provided number of times")
    void whenSuffixRepeatIsProvidedShouldRepeatSuffixProvidedNumberOfTimes() {
        stringEdgeModifier.setValue("Value");
        stringEdgeModifier.addSuffix("Suffix", 3);
        assertEquals("ValueSuffixSuffixSuffix", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when repeat number is negative should throw IllegalArgumentException")
    void whenRepeatNumberIsNegativeShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> stringEdgeModifier.addPrefix("Prefix", -1));
        assertThrows(IllegalArgumentException.class, () -> stringEdgeModifier.addSuffix("Suffix", -1));
    }

    @Test
    @DisplayName("when prefix repeat number is zero should return string without prefix")
    void whenRepeatNumberIsZeroShouldReturnStringWithoutPrefix() {
        stringEdgeModifier.addPrefix("a", 0);
        assertEquals("", stringEdgeModifier.toString());

        stringEdgeModifier.setValue("Value").addPrefix("Prefix", 0);
        assertEquals("Value", stringEdgeModifier.toString());

        stringEdgeModifier.setValue("Value").addPrefix("Prefix1").addPrefix("Prefix2", 0);
        assertEquals("Prefix1Value", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("when suffix repeat number is zero should return string without suffix")
    void whenRepeatNumberIsZeroShouldReturnStringWithoutSuffix() {
        stringEdgeModifier.addSuffix("a", 0);
        assertEquals("", stringEdgeModifier.toString());

        stringEdgeModifier.setValue("Value").addSuffix("Suffix", 0);
        assertEquals("Value", stringEdgeModifier.toString());

        stringEdgeModifier.setValue("Value").addSuffix("Suffix1").addSuffix("Suffix2", 0);
        assertEquals("ValueSuffix1", stringEdgeModifier.toString());
    }

    @Test
    @DisplayName("should return correct length")
    void shouldReturnCorrectLength() {
        assertEquals(0, stringEdgeModifier.length());

        stringEdgeModifier.addPrefix("a", 5);
        assertEquals(5, stringEdgeModifier.length());

        stringEdgeModifier.setValue("TestValue");
        assertEquals(9, stringEdgeModifier.length());
    }

    @Test
    @DisplayName("when char at provided index is queried should return correct char")
    void whenCharAtProvidedIndexIsQueriedShouldReturnCorrectChar() {
        stringEdgeModifier.setValue("TestValue");
        assertEquals('s', stringEdgeModifier.charAt(2));
    }

    @Test
    @DisplayName("when subsequence is queried should return the correct subsequence")
    void whenSubsequenceIsQueriedShouldReturnTheCorrectSubsequence() {
        stringEdgeModifier.setValue("TestValue");
        CharSequence subSequence = stringEdgeModifier.subSequence(1, 5);
        assertEquals("estV", subSequence.toString());
    }
}
