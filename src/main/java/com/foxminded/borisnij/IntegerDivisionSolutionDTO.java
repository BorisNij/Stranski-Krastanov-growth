package com.foxminded.borisnij;

import java.util.List;

public class IntegerDivisionSolutionDTO {
    private final int dividend; // think if needs to be String
    private final int divisor; // think if needs to be String
    private final int quotient; // think if needs to be String
    private final int dividendLength;
    private final int quotientLength;
    private final List<IntegerDivisionStepDTO> divisionSteps;

    public String format(IntegerDivisionSolutionFormatter solutionFormatter) {
        return solutionFormatter.format(this.dividend, this.divisor, this.dividendLength, this.divisionSteps);
    }
}
