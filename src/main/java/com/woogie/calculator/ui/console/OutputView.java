package com.woogie.calculator.ui.console;

import com.woogie.calculator.expression.Operand;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 콘솔로 출력해주는 클래스
 */
public final class OutputView {

    private OutputView() {
    }

    private static void printMessage(Object message) {
        System.out.println(message);
    }

    private static void println() {
        System.out.println();
    }

    public static void printMenu() {
        final String menu = String.join(System.lineSeparator(), "1. 조회", "2. 계산");

        printMessage(menu);
    }

    public static void printChosenMenu(String menu) {
        final String chosenMenu = "선택 : " + menu;

        println();
        printMessage(chosenMenu);
    }

    public static void printExpressions(List<String> expressions) {
        printMessage(expressions.stream().collect(Collectors.joining(System.lineSeparator())));
        println();
    }

    public static void printCalculatedOperand(Operand operand, int scale) {
        printMessage(operand.getValue(scale));
        println();
    }

    public static void printError(RuntimeException ex) {
        printMessage(ex.getMessage());
        println();
    }
}
