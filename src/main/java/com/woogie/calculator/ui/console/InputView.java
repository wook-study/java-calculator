package com.woogie.calculator.ui.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 콘솔로 입력받는 클래스
 */
public final class InputView {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static String readChosenMenu() {
        return read();
    }

    public static String readExpression() {
        return read();
    }
}
