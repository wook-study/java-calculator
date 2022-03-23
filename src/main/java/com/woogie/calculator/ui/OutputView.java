package com.woogie.calculator.ui;

import com.woogie.calculator.expression.Operand;

public class OutputView {
    public void printMenu() {
        System.out.println(String.join(System.lineSeparator(), "1. 조회", "2. 계산"));
    }

    public void printChooseMenu(String chooseMenu) {
        System.out.println("선택 : " + chooseMenu);
    }

    public void printExpression(String expression) {
        System.out.println(expression);
    }

    public void printCalculatedOperand(Operand operand) {
        System.out.println(operand.getValue());
    }
}
