package com.foxminded.borisnij;

public class Task3IntegralDiv {
    public static void main(String[] args) {
        IntegerDivisionOperandConverter operandConverter = new IntegerDivisionOperandConverter();
        IntegerDivisionExercise divisionExpression = new IntegerDivisionExercise(operandConverter.convert(args[0]),
                                                                                     operandConverter.convert(args[1]),
                                                                                 new DivisionStepCalculationService(
                                                                                         divisionStepCache));

        System.out.println(new IntegerDivisionFormatter().format(divisionExpression));
    }
}
