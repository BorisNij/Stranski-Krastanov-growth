package com.foxminded.borisnij;

public class IntegerDivisionFormatter {


    private String getLeftPadding(String partialDividendStr, String divisorMultipleStr) {
        return " ".repeat(partialDividendStr.length() - divisorMultipleStr.length() + 1);
    }

    private String getRightPadding(int dividend, String partialDividendStr) {
        return " ".repeat(String.valueOf(dividend).length() - partialDividendStr.length());
    }

    public String format(IntegerDivisionExercise integerDivisionExercise) {
        final String solutionHeader = parseSolutionHeader(integerDivisionExercise.getDividend(),
                                                          integerDivisionExercise.getDivisor(),
                                                          integerDivisionExercise.getDivisionSteps()
                                                                  .get(0)
                                                                  .getDivisorMultiple());
        final String solutionSteps = parseSolutionSteps(integerDivisionExercise.getDivisionSteps());
        return solutionHeader +
                solutionSteps +
                integerDivisionExercise.getDivisionSteps().get(integerDivisionExercise.getDivisionSteps().size() -
                                                                       1).getPartialDividend();
    }
}
