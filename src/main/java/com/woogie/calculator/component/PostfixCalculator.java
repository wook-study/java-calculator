package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.expression.Operator;

import java.util.Queue;
import java.util.Stack;

/**
 * 후위표현식 계산
 */
public class PostfixCalculator implements Calculatable<Queue<Expression>> {
    private final Stack<Operand> operands;

    public PostfixCalculator() {
        this.operands = new Stack<>();
    }

    @Override
    public Operand calculate(final Queue<Expression> expressions) {
        while (!expressions.isEmpty()) {
            addOperandsUntilOperator(expressions);

            final Expression expression = expressions.poll();

            if (!(expression instanceof Operator)) {
                break;
            }

            addCalculatedOperand((Operator) expression);
        }

        return operands.pop();
    }

    private void addOperandsUntilOperator(final Queue<Expression> expressions) {
        while (true) {
            final Expression expression = expressions.peek();

            if (expression instanceof Operator) {
                break;
            }

            operands.add((Operand) expressions.poll());
        }
    }

    private void addCalculatedOperand(Operator operator) {
        final Operand augend = operands.pop();
        final Operand addend = operands.pop();

        final Operand result = operator.calculate(addend, augend);

        operands.add(result);
    }
}
