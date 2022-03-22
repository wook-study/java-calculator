package com.woogie.calculator.component;

import com.woogie.calculator.domain.expression.Expression;
import com.woogie.calculator.domain.expression.Operand;
import com.woogie.calculator.domain.expression.Operator;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PostfixExpressionChanger implements ExpressionChanger {
    @Override
    public Stack<Expression> change(final List<Expression> expressions) {
        final Stack<Expression> postfixExpressions = new Stack<>();
        final Queue<Expression> temporaryOperators = new ArrayDeque<>();

        for (final Expression expression : expressions) {
            saveOperatorAsTemporary(temporaryOperators, expression);

            saveAsPostfix(postfixExpressions, temporaryOperators, expression);
        }

        return postfixExpressions;
    }

    private void saveOperatorAsTemporary(final Queue<Expression> temporaryOperators, final Expression expression) {
        if (expression instanceof Operator) {
            temporaryOperators.add(expression);
        }
    }

    private void saveAsPostfix(final Stack<Expression> postfixExpressions, final Queue<Expression> temporaryOperators, final Expression expression) {
        if (expression instanceof Operand) {
            postfixExpressions.add(expression);

            if (!temporaryOperators.isEmpty()) {
                postfixExpressions.add(temporaryOperators.poll());
            }
        }
    }
}
