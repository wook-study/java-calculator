package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operator;

import java.util.ArrayDeque;
import java.util.Queue;

public class PostfixExpressionChanger implements ExpressionChanger {
    @Override
    public Queue<Expression> change(final Queue<Expression> expressions) {
        final Queue<Expression> postfixExpressions = new ArrayDeque<>();
        final Queue<Operator> temporaryOperators = new ArrayDeque<>();

        while (!expressions.isEmpty()) {
            addOperandsUntilOperator(postfixExpressions, expressions);

            final Expression expression = expressions.poll();

            if (!(expression instanceof Operator)) {
                break;
            }

            addOperatorsInOrder(temporaryOperators, (Operator) expression);
        }

        postfixExpressions.addAll(temporaryOperators);

        return postfixExpressions;
    }

    private void addOperandsUntilOperator(final Queue<Expression> operands, final Queue<Expression> expressions) {
        while (!expressions.isEmpty()) {
            final Expression expression = expressions.peek();

            if (expression instanceof Operator) {
                break;
            }

            operands.add(expressions.poll());
        }
    }

    private void addOperatorsInOrder(final Queue<Operator> operators, final Operator operator) {
        final Operator previous = operators.peek();

        if (operators.isEmpty() || previous.priority(operator)) {
            operators.add(operator);
        } else {
            operators.poll();

            operators.add(operator);
            operators.add(previous);
        }
    }
}
