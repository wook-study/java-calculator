package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.expression.Operator;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class PostfixExpressionChanger implements ExpressionChanger {
    @Override
    public Queue<Expression> change(final List<Expression> expressions) {
        final Queue<Expression> postfixExpressions = new ArrayDeque<>();
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

    private void saveAsPostfix(final Queue<Expression> postfixExpressions, final Queue<Expression> temporaryOperators, final Expression expression) {
        if (expression instanceof Operand) {
            postfixExpressions.add(expression);

            if (!temporaryOperators.isEmpty()) {
                postfixExpressions.add(temporaryOperators.poll());
            }
        }
    }
}
