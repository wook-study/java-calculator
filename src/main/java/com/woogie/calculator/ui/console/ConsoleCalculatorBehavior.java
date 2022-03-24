package com.woogie.calculator.ui.console;

import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.ui.CalculatorBehavior;

/**
 * 콘솔로 실행하는 계산기
 */
public class ConsoleCalculatorBehavior implements CalculatorBehavior {

    private final InputView inputView;
    private final OutputView outputView;

    public ConsoleCalculatorBehavior(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void start() {
        outputView.printMenu();
        final String chosenMenu = inputView.readChosenMenu();

        outputView.printChosenMenu(chosenMenu);

        final String expression = inputView.readExpression();



        outputView.printCalculatedOperand(new Operand(3), 0);
    }
}
