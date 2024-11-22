package net.bnijik.intDivApp.service;

import net.bnijik.intDivApp.calculator.IntegerDivisionCalculator;
import net.bnijik.intDivApp.dto.IntegerDivisionSolutionDTO;
import net.bnijik.intDivApp.dto.IntegerDivisionStepDTO;
import net.bnijik.intDivApp.model.IntegerDivisionStep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IntegerDivisionSolutionServiceImplTest {

    @Mock
    IntegerDivisionCalculator integerDivisionCalculator;
    @InjectMocks
    private IntegerDivisionSolutionServiceImpl solutionService;

    private static Stream<Arguments> provideTestData() {
        return Stream.of(Arguments.of(167,
                                      7,
                                      List.of(new IntegerDivisionStep(16, 14, '2'),
                                              new IntegerDivisionStep(27, 21, '3'),
                                              new IntegerDivisionStep(6, 0, '\0')),
                                      "167",
                                      "7",
                                      "23",
                                      "14",
                                      2,
                                      List.of(new IntegerDivisionStepDTO("27", "21"),
                                              new IntegerDivisionStepDTO("6", "0"))),
                         Arguments.of(1672,
                                      2300,
                                      List.of(new IntegerDivisionStep(1672, 0, '0'),
                                              new IntegerDivisionStep(1672, 0, '\0')),
                                      "1672",
                                      "2300",
                                      "0",
                                      "0",
                                      1,
                                      List.of(new IntegerDivisionStepDTO("1672", "0"))),
                         Arguments.of(23456,
                                      7,
                                      List.of(new IntegerDivisionStep(23, 21, '3'),
                                              new IntegerDivisionStep(24, 21, '3'),
                                              new IntegerDivisionStep(35, 35, '5'),
                                              new IntegerDivisionStep(6, 0, '0'),
                                              new IntegerDivisionStep(6, 0, '\0')),
                                      "23456",
                                      "7",
                                      "3350",
                                      "21",
                                      2,
                                      List.of(new IntegerDivisionStepDTO("24", "21"),
                                              new IntegerDivisionStepDTO("35", "35"),
                                              new IntegerDivisionStepDTO("06", "0"),
                                              new IntegerDivisionStepDTO("6", "0"))));
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    @DisplayName("when provided with valid input should return expected DTO")
    void whenProvidedWithValidInputShouldReturnExpectedDto(int dividend,
                                                           int divisor,
                                                           List<IntegerDivisionStep> mockSteps,
                                                           String expectedDividend,
                                                           String expectedDivisor,
                                                           String expectedQuotient,
                                                           String expectedFirstDivisorMultiple,
                                                           int expectedPartialDividendLength,
                                                           List<IntegerDivisionStepDTO> expectedDivisionStepsDTO) {

        when(integerDivisionCalculator.calculateDivisionStepsForOperands(dividend, divisor)).thenReturn(mockSteps);

        IntegerDivisionSolutionDTO result = solutionService.createSolutionForOperands(dividend, divisor);

        assertEquals(expectedDividend, result.getDividend());
        assertEquals(expectedDivisor, result.getDivisor());
        assertEquals(expectedFirstDivisorMultiple, result.getFirstDivisorMultiple());
        assertEquals(expectedPartialDividendLength, result.getFirstPartialDividendLength());
        assertEquals(expectedQuotient, result.getQuotient());

        assertEquals(expectedDivisionStepsDTO, result.getDivisionSteps());
    }
}