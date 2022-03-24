package com.woogie.calculator.ui.console;

import com.woogie.calculator.expression.Operand;

import java.io.IOException;
import java.io.OutputStream;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;

/**
 * 콘솔로 출력해주는 클래스
 */
public class OutputView {

    private final OutputStream out;

    public OutputView(OutputStream out) {
        this.out = out;
    }

    public static OutputView create() {
        return new OutputView(System.out);
    }

    public void println(String content) {
        try {
            out.write(content.getBytes(StandardCharsets.UTF_8));
            out.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printMenu() {
        final String menu = String.join(System.lineSeparator(), "1. 조회", "2. 계산");

        println(menu);
    }

    public void printChosenMenu(String menu) {
        final String chosenMenu = "선택 : " + menu;

        println(chosenMenu);
    }

    public void printExpression(String expression) {
        System.out.println(expression);
    }

    public void printCalculatedOperand(Operand operand) {
        System.out.println(operand.getValue());
    }

    public void printCalculatedOperand(Operand operand, int scale) {
        System.out.println(operand.getValue(scale));
    }

    public void printCalculatedOperand(Operand operand, int scale, RoundingMode roundingMode) {
        System.out.println(operand.getValue(scale, roundingMode));
    }
}
