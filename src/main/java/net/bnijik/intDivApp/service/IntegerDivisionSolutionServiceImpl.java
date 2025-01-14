package net.bnijik.intDivApp.service;

import net.bnijik.intDivApp.calculator.IntegerDivisionCalculator;
import net.bnijik.intDivApp.dto.IntegerDivisionSolutionDTO;
import net.bnijik.intDivApp.dto.IntegerDivisionStepDTO;
import net.bnijik.intDivApp.model.IntegerDivisionStep;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerDivisionSolutionServiceImpl implements IntegerDivisionSolutionService {
    private final IntegerDivisionCalculator integerCalculator;

    public IntegerDivisionSolutionServiceImpl(IntegerDivisionCalculator integerCalculator) {
        this.integerCalculator = integerCalculator;
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

    @Override
    public IntegerDivisionSolutionDTO createSolutionForOperands(int dividend, int divisor) {
        final List<IntegerDivisionStep> divisionSteps = integerCalculator.calculateDivisionStepsForOperands(dividend,
                                                                                                            divisor);
        final List<IntegerDivisionStepDTO> solutionSteps = IntStream.range(1, divisionSteps.size())
                .mapToObj(i -> divisionStepToDTO(divisionSteps.get(i), divisionSteps.get(i - 1)))
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

    private IntegerDivisionStepDTO divisionStepToDTO(IntegerDivisionStep currentDivisionStep,
                                                     IntegerDivisionStep previousDivisionStep) {
        final String partialDividendString;
        if (previousDivisionStep.getPartialDividend() != previousDivisionStep.getDivisorMultiple())
            partialDividendString = intToString(currentDivisionStep.getPartialDividend());
        else partialDividendString = "0" + intToString(currentDivisionStep.getPartialDividend());
        return new IntegerDivisionStepDTO(partialDividendString, intToString(currentDivisionStep.getDivisorMultiple()));
    }
}
