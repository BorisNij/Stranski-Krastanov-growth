package com.foxminded.borisnij;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerDividerTest {

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(167, 7, Arrays.asList(
                        new IntegerDivisionStep(16, 14, '2'),
                        new IntegerDivisionStep(27, 21, '3'),
                        new IntegerDivisionStep(6, 0, '\0')
                )),
                Arguments.of(167, 71, Arrays.asList(
                        new IntegerDivisionStep(167, 142, '2'),
                        new IntegerDivisionStep(25, 0, '\0')
                )),
                Arguments.of(738, 7, Arrays.asList(
                        new IntegerDivisionStep(7, 7, '1'),
                        new IntegerDivisionStep(3, 0, '0'),
                        new IntegerDivisionStep(38, 35, '5'),
                        new IntegerDivisionStep(3, 0, '\0')
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("When provided with valid dividend and divisor should return correct division steps")
    void whenProvidedWithValidDividendAndDivisorShouldReturnCorrectDivisionSteps(int dividend, int divisor, List<IntegerDivisionStep> expectedSteps) {
        IntegerDivider divider = new IntegerDivider();
        List<IntegerDivisionStep> actualSteps = divider.divide(dividend, divisor);

        assertEquals(expectedSteps, actualSteps);
    }
}
