package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.expression.Operator;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixExpressionChangerTest {

    @Test
    void 중위표현을_후위표현식으로_변경성공() {
        final Queue<Expression> inorderExpressions = new ArrayDeque<>();
        inorderExpressions.add(new Operand(3));
        inorderExpressions.add(Operator.ADDITION);
        inorderExpressions.add(new Operand(2));
        inorderExpressions.add(Operator.MULTIPLICATION);
        inorderExpressions.add(new Operand(4));

        final int inorderSize = inorderExpressions.size();

        final PostfixExpressionChanger postfixExpressionChanger = new PostfixExpressionChanger();

        final Queue<Expression> postfixExpressions = postfixExpressionChanger.change(inorderExpressions);

        assertThat(postfixExpressions.size() == inorderSize).isTrue();

        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(3));
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(2));
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(4));
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.MULTIPLICATION);
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.ADDITION);
    }
}