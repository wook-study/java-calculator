package com.woogie.calculator;

import com.woogie.calculator.ui.CalculatorBehavior;
import com.woogie.calculator.ui.console.ConsoleCalculatorBehavior;
import com.woogie.calculator.ui.console.InputView;
import com.woogie.calculator.ui.console.OutputView;

public class Application {
    public static void main(String[] args) {
        final CalculatorBehavior calculator = new ConsoleCalculatorBehavior(InputView.create(), OutputView.create());

        calculator.start();
    }
}
