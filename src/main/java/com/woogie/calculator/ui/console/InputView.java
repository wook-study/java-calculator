package com.woogie.calculator.ui.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InputView {
    private final BufferedReader reader;

    public InputView(BufferedReader reader) {
        this.reader = reader;
    }

    public static InputView create() {
        return new InputView(new BufferedReader(new InputStreamReader(System.in)));
    }

    public String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public String readChosenMenu() {
        return read();
    }

    public String readExpression() {
        return read();
    }
}
