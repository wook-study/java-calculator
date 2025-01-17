package com.woogie.calculator;

import com.woogie.calculator.component.PostfixCalculator;
import com.woogie.calculator.component.PostfixExpressionChanger;
import com.woogie.calculator.parser.RegExExpressionValidator;
import com.woogie.calculator.parser.StringToExpressionParser;
import com.woogie.calculator.repository.ExpressionHistoryRepository;
import com.woogie.calculator.ui.CalculatorBehavior;
import com.woogie.calculator.ui.console.ConsoleCalculatorBehavior;

public class Application {
    public static void main(String[] args) {
        final CalculatorBehavior calculator = new ConsoleCalculatorBehavior(
                new StringToExpressionParser(new RegExExpressionValidator()), new PostfixExpressionChanger(),
                new PostfixCalculator(), new ExpressionHistoryRepository());

        calculator.run();
    }
}
