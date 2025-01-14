package net.bnijik.intDivApp.calculator;

import net.bnijik.intDivApp.model.IntegerDivisionStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerDivisionCalculatorImplTest {
    IntegerDivisionCalculator divider;

    @BeforeEach
    void init() {
        divider = new IntegerDivisionCalculatorImpl();
    }

    static Stream<Arguments> testData() {

        return Stream.of(
                Arguments.of(2647, 13,
                             Arrays.asList(
                                     new IntegerDivisionStep(26, 26, '2'),
                                     new IntegerDivisionStep(4, 0, '0'),
                                     new IntegerDivisionStep(47, 39, '3'),
                                     new IntegerDivisionStep(8, 0, '\0')
                )),
                Arguments.of(167, 7,
                             Arrays.asList(
                                     new IntegerDivisionStep(16, 14, '2'),
                                     new IntegerDivisionStep(27, 21, '3'),
                                     new IntegerDivisionStep(6, 0, '\0')
                )),
                Arguments.of(167, 71,
                             Arrays.asList(
                                     new IntegerDivisionStep(167, 142, '2'),
                                     new IntegerDivisionStep(25, 0, '\0')
                )),
                Arguments.of(738, 7,
                             Arrays.asList(
                                     new IntegerDivisionStep(7, 7, '1'),
                                     new IntegerDivisionStep(3, 0, '0'),
                                     new IntegerDivisionStep(38, 35, '5'),
                                     new IntegerDivisionStep(3, 0, '\0')
                )),
                Arguments.of(78945, 76,
                             Arrays.asList(
                                     new IntegerDivisionStep(78, 76, '1'),
                                     new IntegerDivisionStep(29, 0, '0'),
                                     new IntegerDivisionStep(294, 228, '3'),
                                     new IntegerDivisionStep(665, 608, '8'),
                                     new IntegerDivisionStep(57, 0, '\0')
                )),
                Arguments.of(1, 1,
                             Arrays.asList(
                                     new IntegerDivisionStep(1, 1, '1'),
                                     new IntegerDivisionStep(0, 0, '\0')
                )),
                Arguments.of(0, 1,
                             Arrays.asList(
                                     new IntegerDivisionStep(0, 0, '0'),
                                     new IntegerDivisionStep(0, 0, '\0')
                )),
                Arguments.of(0, 25,
                             Arrays.asList(
                                     new IntegerDivisionStep(0, 0, '0'),
                                     new IntegerDivisionStep(0, 0, '\0')
                )),
                Arguments.of(1, 25,
                             Arrays.asList(
                                     new IntegerDivisionStep(1, 0, '0'),
                                     new IntegerDivisionStep(1, 0, '\0')
                )),
                Arguments.of(2, 7,
                             Arrays.asList(
                                     new IntegerDivisionStep(2, 0, '0'),
                                     new IntegerDivisionStep(2, 0, '\0')
                )),
                Arguments.of(12, 25,
                             Arrays.asList(
                                     new IntegerDivisionStep(12, 0, '0'),
                                     new IntegerDivisionStep(12, 0, '\0')
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("When provided with valid dividend and divisor should return correct division steps")
    void whenProvidedWithValidDividendAndDivisorShouldReturnCorrectDivisionSteps(
            int dividend,
            int divisor,
            List<IntegerDivisionStep> expectedSteps) {


        List<IntegerDivisionStep> actualSteps = divider.calculateDivisionStepsForOperands(dividend, divisor);

        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    @DisplayName("When provided with divisor 0 should throw IllegalArgumentException")
    void whenProvidedWithDivisor0ShouldThrowIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> divider.calculateDivisionStepsForOperands(123, 0));
    }

    @Test
    @DisplayName("When provided with negative divisor should throw IllegalArgumentException")
    void whenProvidedWithNegativeDivisorShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> divider.calculateDivisionStepsForOperands(123, -2));
    }

    @Test
    @DisplayName("When provided with negative dividend should throw IllegalArgumentException")
    void whenProvidedWithNegativeDividendShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> divider.calculateDivisionStepsForOperands(-3, 1));
    }

}
