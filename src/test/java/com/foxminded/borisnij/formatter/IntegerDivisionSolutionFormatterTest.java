package com.foxminded.borisnij.formatter;

import com.foxminded.borisnij.dto.IntegerDivisionStepDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerDivisionSolutionFormatterTest {

    private IntegerDivisionSolutionFormatter formatter;

    private static Stream<Arguments> formatTestCases() {
        return Stream.of(Arguments.of("78945",
                                      "76",
                                      "1038",
                                      "76",
                                      2,
                                      List.of(new IntegerDivisionStepDTO("29", "0"),
                                              new IntegerDivisionStepDTO("294", "228"),
                                              new IntegerDivisionStepDTO("665", "608"),
                                              new IntegerDivisionStepDTO("57", "0")),
                                      "_78945|76\n" +
                                              " 76   |----\n" +
                                              " --   |1038\n" +
                                              " _29\n" +
                                              "  0\n" +
                                              "  --\n" +
                                              " _294\n" +
                                              "  228\n" +
                                              "  ---\n" +
                                              "  _665\n" +
                                              "   608\n" +
                                              "   ---\n" +
                                              "    57"),
                         Arguments.of("78945",
                                      "4",
                                      "19736",
                                      "4",
                                      1,
                                      List.of(new IntegerDivisionStepDTO("38", "36"),
                                              new IntegerDivisionStepDTO("29", "28"),
                                              new IntegerDivisionStepDTO("14", "12"),
                                              new IntegerDivisionStepDTO("25", "24"),
                                              new IntegerDivisionStepDTO("1", "0")),
                                      "_78945|4\n" +
                                              " 4    |-----\n" +
                                              " -    |19736\n" +
                                              "_38\n" +
                                              " 36\n" +
                                              " --\n" +
                                              " _29\n" +
                                              "  28\n" +
                                              "  --\n" +
                                              "  _14\n" +
                                              "   12\n" +
                                              "   --\n" +
                                              "   _25\n" +
                                              "    24\n" +
                                              "    --\n" +
                                              "     1"),
                         Arguments.of("1672",
                                      "2300",
                                      "0",
                                      "0",
                                      1,
                                      List.of(new IntegerDivisionStepDTO("1672", "2300")),
                                      "_1672|2300\n" +
                                              " 0   |-\n" +
                                              " -   |0\n" +
                                              " 1672"));
    }

    @BeforeEach
    void setUp() {
        formatter = new IntegerDivisionSolutionFormatter.Builder().build();
    }

    @ParameterizedTest
    @MethodSource("formatTestCases")
    void testFormat(String dividend,
                    String divisor,
                    String quotient,
                    String firstDivisorMultiple,
                    int firstPartialDividendLength,
                    List<IntegerDivisionStepDTO> divisionSteps,
                    String expectedFormattedSolution) {

        String actualFormattedSolution = formatter.format(dividend,
                                                          divisor,
                                                          quotient,
                                                          firstDivisorMultiple,
                                                          firstPartialDividendLength,
                                                          divisionSteps);

        assertEquals(expectedFormattedSolution, actualFormattedSolution);
    }
}