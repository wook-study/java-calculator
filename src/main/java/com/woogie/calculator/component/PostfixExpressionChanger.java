package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operator;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 후위표현식으로 표현방식 변경
 */
public class PostfixExpressionChanger implements ExpressionChanger {
    private final Queue<Expression> postfixExpressions;
    private final Stack<Operator> temporaryOperators;

    public PostfixExpressionChanger() {
        this.postfixExpressions = new ArrayDeque<>();
        this.temporaryOperators = new Stack<>();
    }

    @Override
    public Queue<Expression> change(final Queue<Expression> expressions) {
        clear();

        while (!expressions.isEmpty()) {
            addOperandsUntilOperator(expressions);

            final Expression expression = expressions.poll();

            if (!(expression instanceof Operator)) {
                break;
            }

            addTemporaryOperator((Operator) expression);
        }

        final Stack<Operator> sortedOperators = changeOrderByPriority();

        postfixExpressions.addAll(sortedOperators);

        return new ArrayDeque<>(postfixExpressions);
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

    private void addTemporaryOperator(final Operator operator) {
        switch (operator) {
            case MULTIPLICATION:
            case DIVISION:
                temporaryOperators.add(operator);

                break;
            case ADDITION:
            case SUBTRACTION:
                while (!temporaryOperators.empty()) {
                    postfixExpressions.add(temporaryOperators.pop());
                }

                temporaryOperators.add(operator);

                break;
        }
    }

    private Stack<Operator> changeOrderByPriority() {
        return temporaryOperators.stream()
                                 .sorted(Comparator.comparing(Operator::getOrder))
                                 .collect(Collectors.toCollection(Stack::new));
    }

    private void clear() {
        postfixExpressions.clear();
        temporaryOperators.clear();
    }
}
