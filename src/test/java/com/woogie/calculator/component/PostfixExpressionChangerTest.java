package com.woogie.calculator.component;

import com.woogie.calculator.Expression;
import com.woogie.calculator.operand.Operand;
import com.woogie.calculator.operator.Operator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixExpressionChangerTest {

    @Test
    void 중위표현을_후위표현식으로_변경성공() {
        final List<Expression> inorderExpressions = List.of(new Operand(3), Operator.ADDITION, new Operand(2), Operator.MULTIPLICATION, new Operand(4));

        final PostfixExpressionChanger postfixExpressionChanger = new PostfixExpressionChanger();

        final Stack<Expression> postfixExpressions = postfixExpressionChanger.change(inorderExpressions);

        assertThat(postfixExpressions.size() == inorderExpressions.size()).isTrue();

        assertThat(postfixExpressions.pop()).isEqualTo(Operator.MULTIPLICATION);
        assertThat(postfixExpressions.pop()).isEqualTo(new Operand(4));
        assertThat(postfixExpressions.pop()).isEqualTo(Operator.ADDITION);
        assertThat(postfixExpressions.pop()).isEqualTo(new Operand(2));
        assertThat(postfixExpressions.pop()).isEqualTo(new Operand(3));
    }
}