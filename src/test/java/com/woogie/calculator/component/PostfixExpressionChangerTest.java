package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.expression.Operator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixExpressionChangerTest {

    @Test
    void 중위표현을_후위표현식으로_변경성공() {
        final List<Expression> inorderExpressions = List.of(new Operand(3), Operator.ADDITION, new Operand(2), Operator.MULTIPLICATION, new Operand(4));

        final PostfixExpressionChanger postfixExpressionChanger = new PostfixExpressionChanger();

        final Queue<Expression> postfixExpressions = postfixExpressionChanger.change(inorderExpressions);

        assertThat(postfixExpressions.size() == inorderExpressions.size()).isTrue();

        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(3));
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(2));
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.ADDITION);
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(4));
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.MULTIPLICATION);
    }
}