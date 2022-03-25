package com.woogie.calculator;

import com.woogie.calculator.component.PostfixCalculator;
import com.woogie.calculator.component.PostfixExpressionChanger;
import com.woogie.calculator.component.RegExExpressionValidator;
import com.woogie.calculator.component.StringToExpressionParser;
import com.woogie.calculator.ui.CalculatorBehavior;
import com.woogie.calculator.ui.console.ConsoleCalculatorBehavior;
import com.woogie.calculator.ui.console.InputView;

public class Application {
    public static void main(String[] args) {
        final CalculatorBehavior calculator = new ConsoleCalculatorBehavior(
                new StringToExpressionParser(new RegExExpressionValidator()), new PostfixExpressionChanger(),
                new PostfixCalculator()
        );

        calculator.run();
    }
}
