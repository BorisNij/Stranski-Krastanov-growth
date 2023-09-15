package com.foxminded.borisnij.formatter;

import com.foxminded.borisnij.dto.IntegerDivisionStepDTO;

import java.util.List;

public interface IntegerDivisionSolutionFormatter {
    String format(String dividend,
                  String divisor,
                  String quotient,
                  String firstDivisorMultiple,
                  int firstPartialDividendLength,
                  List<IntegerDivisionStepDTO> divisionSteps);
}
