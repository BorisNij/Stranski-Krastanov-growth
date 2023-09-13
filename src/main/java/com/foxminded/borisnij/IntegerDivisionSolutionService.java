package com.foxminded.borisnij;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerDivisionSolutionService {
    private final IntegerDivisionCalculator integerCalculator;

    public IntegerDivisionSolutionService(IntegerDivisionCalculator integerCalculator) {
        this.integerCalculator = integerCalculator;
    }

    private static String getQuotientFromDivisionSteps(List<IntegerDivisionStep> divisionSteps) {

        return divisionSteps.stream()
                .limit(divisionSteps.size() - 1)
                .map(divisionStep -> String.valueOf(divisionStep.getQuotientDigit()))
                .collect(Collectors.joining());
    }

    private static int countDigits(int inputInteger) {
        return String.valueOf(inputInteger).length();
    }

    private static String intToString(int integer) {
        return String.valueOf(integer);
    }

    public IntegerDivisionSolutionDTO createSolutionForOperands(int dividend, int divisor) {
        final List<IntegerDivisionStep> divisionSteps = integerCalculator.calculateDivisionStepsForOperands(dividend,
                                                                                                            divisor);
        final List<IntegerDivisionStepDTO> solutionSteps = divisionSteps.stream()
                .skip(1)
                .map(this::divisionStepToDTO)
                .collect(Collectors.toList());
        final String quotient = getQuotientFromDivisionSteps(divisionSteps);
        final IntegerDivisionStep firstStep = divisionSteps.get(0);
        return new IntegerDivisionSolutionDTO.Builder().dividend(intToString(dividend))
                .divisor(intToString(divisor))
                .quotient(quotient)
                .firstDivisorMultiple(intToString(firstStep.getDivisorMultiple()))
                .firstPartialDividendLength(countDigits(firstStep.getPartialDividend()))
                .divisionSteps(solutionSteps)
                .build();
    }

    private IntegerDivisionStepDTO divisionStepToDTO(IntegerDivisionStep divisionStep) {
        return new IntegerDivisionStepDTO(intToString(divisionStep.getPartialDividend()),
                                          intToString(divisionStep.getDivisorMultiple()));
    }
}
