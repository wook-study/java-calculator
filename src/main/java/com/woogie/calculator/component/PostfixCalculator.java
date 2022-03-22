package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.expression.Operator;

import java.util.Queue;
import java.util.Stack;

public class PostfixCalculator implements Calculatable<Queue<Expression>> {
    @Override
    public Operand calculate(final Queue<Expression> expressions) {
        final Stack<Operand> operands = new Stack<>();

        while (!expressions.isEmpty()) {
            addOperandsUntilOperator(operands, expressions);

            final Expression expression = expressions.poll();

            if (!(expression instanceof Operator)) {
                break;
            }

            addCalculatedOperand(operands, (Operator) expression);
        }

        return operands.pop();
    }

    private void addOperandsUntilOperator(final Stack<Operand> operands, final Queue<Expression> expressions) {
        while (true) {
            final Expression expression = expressions.peek();

            if (expression instanceof Operator) {
                break;
            }

            operands.add((Operand) expressions.poll());
        }
    }

    private void addCalculatedOperand(Stack<Operand> operands, Operator operator) {
        final Operand augend = operands.pop();
        final Operand addend = operands.pop();

        final Operand result = operator.calculate(augend, addend);

        operands.add(result);
    }
}
