package net.bnijik.intDivApp.service;

import net.bnijik.intDivApp.dto.IntegerDivisionSolutionDTO;

public interface IntegerDivisionSolutionService {
    IntegerDivisionSolutionDTO createSolutionForOperands(int dividend, int divisor);
}
