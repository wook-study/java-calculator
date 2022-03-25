package com.woogie.calculator.ui.console;

import com.woogie.calculator.expression.Operand;

/**
 * 콘솔로 출력해주는 클래스
 */
public final class OutputView {

    private OutputView() {
    }

    private static void println(Object message) {
        System.out.println(message);
    }

    public static void printMenu() {
        final String menu = String.join(System.lineSeparator(), "1. 조회", "2. 계산");

        println(menu);
    }

    public static void printChosenMenu(String menu) {
        final String chosenMenu = "선택 : " + menu;

        println(chosenMenu);
    }

    public static void printCalculatedOperand(Operand operand, int scale) {
        println(operand.getValue(scale));
    }

    public static void printError(RuntimeException ex) {
        println(ex.getMessage());
    }
}
