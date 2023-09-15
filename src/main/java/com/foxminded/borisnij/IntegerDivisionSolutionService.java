package com.foxminded.borisnij;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerDivisionSolutionService {
    private final IntegerDivisionCalculator integerCalculator;

    public IntegerDivisionSolutionService(IntegerDivisionCalculator integerCalculator) {
        this.integerCalculator = integerCalculator;
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
                .firstPartialDividendLength(getFirstPartialDividendLength(quotient, firstStep.getPartialDividend()))
                .divisionSteps(solutionSteps)
                .build();
    }

    private IntegerDivisionStepDTO divisionStepToDTO(IntegerDivisionStep divisionStep) {
        return new IntegerDivisionStepDTO(intToString(divisionStep.getPartialDividend()),
                                          intToString(divisionStep.getDivisorMultiple()));
    }

    private static int getFirstPartialDividendLength(String quotient, int firstPartialDividend) {
        return !quotient.equals("0") ? countDigits(firstPartialDividend) : 1;
    }

    private static String getQuotientFromDivisionSteps(List<IntegerDivisionStep> divisionSteps) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, divisionStepsSize = divisionSteps.size(); i < divisionStepsSize - 1; i++) {
            sb.append(divisionSteps.get(i).getQuotientDigit());
        }
        return sb.toString();
    }

    private static int countDigits(int inputInteger) {
        return String.valueOf(inputInteger).length();
    }

    private static String intToString(int integer) {
        return String.valueOf(integer);
    }
}
