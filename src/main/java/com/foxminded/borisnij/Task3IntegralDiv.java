package com.foxminded.borisnij;

public class Task3IntegralDiv {
    public static void main(String[] args) {
        IntegerDivisionOperandConverter operandConverter = new IntegerDivisionOperandConverter();
        IntegerDivisionExpression divisionExpression = new IntegerDivisionExpression(operandConverter.convert(args[0]),
                                                                                     operandConverter.convert(args[1]),
                                                                                     new IntegerDivider());

        System.out.println(new IntegerDivisionFormatter().format(divisionExpression));
    }
}
