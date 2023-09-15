package com.foxminded.borisnij.service;

import com.foxminded.borisnij.dto.IntegerDivisionSolutionDTO;

public interface IntegerDivisionSolutionService {
    IntegerDivisionSolutionDTO createSolutionForOperands(int dividend, int divisor);
}
