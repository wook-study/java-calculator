package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operator;

import java.util.ArrayDeque;
import java.util.Queue;

public class PostfixExpressionChanger implements ExpressionChanger {
    private final Queue<Expression> postfixExpressions;
    private final Queue<Operator> temporaryOperators;

    public PostfixExpressionChanger() {
        this.postfixExpressions = new ArrayDeque<>();
        this.temporaryOperators = new ArrayDeque<>();
    }

    @Override
    public Queue<Expression> change(final Queue<Expression> expressions) {
        while (!expressions.isEmpty()) {
            addOperandsUntilOperator(expressions);

            final Expression expression = expressions.poll();

            if (!(expression instanceof Operator)) {
                break;
            }

            addOperatorsInOrder((Operator) expression);
        }

        postfixExpressions.addAll(temporaryOperators);

        return postfixExpressions;
    }

    private void addOperandsUntilOperator(final Queue<Expression> expressions) {
        while (!expressions.isEmpty()) {
            final Expression expression = expressions.peek();

            if (expression instanceof Operator) {
                break;
            }

            postfixExpressions.add(expressions.poll());
        }
    }

    private void addOperatorsInOrder(final Operator operator) {
        final Operator previous = temporaryOperators.peek();

        if (temporaryOperators.isEmpty() || previous.priority(operator)) {
            temporaryOperators.add(operator);
        } else {
            temporaryOperators.poll();

            temporaryOperators.add(operator);
            temporaryOperators.add(previous);
        }
    }
}
