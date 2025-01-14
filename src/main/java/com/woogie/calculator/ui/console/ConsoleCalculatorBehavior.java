package com.woogie.calculator.ui.console;

import com.woogie.calculator.component.Calculatable;
import com.woogie.calculator.component.ExpressionChanger;
import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.parser.ExpressionParser;
import com.woogie.calculator.repository.ExpressionHistoryRepository;
import com.woogie.calculator.ui.AbstractCalculatorBehavior;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

import static com.woogie.calculator.ui.console.InputView.readChosenMenu;
import static com.woogie.calculator.ui.console.InputView.readExpression;
import static com.woogie.calculator.ui.console.OutputView.*;

/**
 * 콘솔로 실행하는 계산기
 */
public class ConsoleCalculatorBehavior extends AbstractCalculatorBehavior {

    private final ExpressionParser<String> expressionParser;
    private final ExpressionChanger expressionChanger;
    private final Calculatable<Queue<Expression>> calculator;
    private final ExpressionHistoryRepository repository;

    public ConsoleCalculatorBehavior(ExpressionParser<String> expressionParser, ExpressionChanger expressionChanger,
                                     Calculatable<Queue<Expression>> calculator, ExpressionHistoryRepository repository) {
        this.expressionParser = expressionParser;
        this.expressionChanger = expressionChanger;
        this.calculator = calculator;
        this.repository = repository;
    }

    @Override
    protected boolean isCompleted() {
        return true;
    }

    @Override
    protected void start() {
        final Menu chosenMenu = chooseMenu();

        chosenMenu.execute(
                () -> printExpressions(repository.findAll()),
                () -> printCalculatedOperand(calculate(), 0)
        );
    }

    @Override
    protected void complete() {
    }

    @Override
    protected void error(final RuntimeException ex) {
        printError(ex);
    }

    private Menu chooseMenu() {
        printMenu();

        final String chosenMenu = readChosenMenu();

        printChosenMenu(chosenMenu);

        return Menu.of(chosenMenu);
    }

    private Queue<Expression> prepareExpressions(final String expression) {
        final Collection<Expression> expressions = expressionParser.parse(expression);

        return new ArrayDeque<>(expressionChanger.change(new ArrayDeque<>(expressions)));
    }

    private Operand calculate() {
        final String expression = readExpression();
        final Queue<Expression> expressions = prepareExpressions(expression);

        final Operand result = calculator.calculate(expressions);

        repository.save(String.join(" = ", expression, result.toString()));

        return result;
    }

    private enum Menu {
        FETCH_ALL(1), CALCULATION(2);

        private final int number;

        Menu(final int number) {this.number = number;}

        public static Menu of(String number) {
            try {
                final int parsedNumber = Integer.parseInt(number);

                return Arrays.stream(values())
                             .filter(it -> it.number == parsedNumber)
                             .findFirst()
                             .orElseThrow(() -> new IllegalArgumentException("1. 2. 둘중 하나만 선택해주세요."));
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("숫자만 입력해주세요.", ex);
            }
        }

        public void execute(final FetchAll fetchAll, final Calculation calculation) {
            switch (this) {
                case FETCH_ALL:
                    fetchAll.execute();
                    break;
                case CALCULATION:
                    calculation.execute();
                    break;
            }
        }

        @FunctionalInterface
        private interface FetchAll {
            void execute();
        }

        @FunctionalInterface
        private interface Calculation {
            void execute();
        }
    }
}
