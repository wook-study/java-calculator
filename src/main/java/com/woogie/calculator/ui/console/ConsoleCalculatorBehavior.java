package com.woogie.calculator.ui.console;

import com.woogie.calculator.component.Calculatable;
import com.woogie.calculator.component.ExpressionChanger;
import com.woogie.calculator.component.ExpressionParser;
import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.ui.AbstractCalculatorBehavior;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

import static com.woogie.calculator.ui.console.OutputView.*;

/**
 * 콘솔로 실행하는 계산기
 */
public class ConsoleCalculatorBehavior extends AbstractCalculatorBehavior {

    private final InputView inputView;
    private final ExpressionParser<String> expressionParser;
    private final ExpressionChanger expressionChanger;
    private final Calculatable<Queue<Expression>> calculator;

    public ConsoleCalculatorBehavior(
            InputView inputView,
            ExpressionParser<String> expressionParser, ExpressionChanger expressionChanger,
            Calculatable<Queue<Expression>> calculator) {
        this.inputView = inputView;
        this.expressionParser = expressionParser;
        this.expressionChanger = expressionChanger;
        this.calculator = calculator;
    }

    @Override
    protected void start() {
        printMenu();
        final String chosenMenu = inputView.readChosenMenu();

        printChosenMenu(chosenMenu);

        if (!chosenMenu.matches("[1|2]")) {
            throw new IllegalArgumentException("1. 2. 둘중 하나만 선택해주세요.");
        }

        final String expression = inputView.readExpression();
        final Queue<Expression> expressions = prepareExpressions(expression);

        final Operand operand = calculator.calculate(expressions);

        printCalculatedOperand(operand, 0);
    }

    @Override
    protected void complete() {

    }

    @Override
    protected void error(final RuntimeException ex) {
        OutputView.println(ex.getMessage());
    }

    private Queue<Expression> prepareExpressions(final String expression) {
        final Collection<Expression> expressions = expressionParser.parse(expression);

        return new ArrayDeque<>(expressionChanger.change(new ArrayDeque<>(expressions)));
    }
}
