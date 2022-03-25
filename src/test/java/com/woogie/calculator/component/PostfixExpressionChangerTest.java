package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.expression.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixExpressionChangerTest {

    private PostfixExpressionChanger postfixExpressionChanger;

    @BeforeEach
    void setUp() {
        postfixExpressionChanger = new PostfixExpressionChanger();
    }

    @Test
    void 중위표현을_후위표현식으로_변경성공() {
        final Queue<Expression> infixExpressions = new ArrayDeque<>();

        infixExpressions.add(new Operand(8));
        infixExpressions.add(Operator.DIVISION);
        infixExpressions.add(new Operand(2));
        infixExpressions.add(Operator.SUBTRACTION);
        infixExpressions.add(new Operand(3));
        infixExpressions.add(Operator.ADDITION);
        infixExpressions.add(new Operand(3));
        infixExpressions.add(Operator.MULTIPLICATION);
        infixExpressions.add(new Operand(2));

        final int infixSize = infixExpressions.size();

        final Queue<Expression> postfixExpressions = postfixExpressionChanger.change(infixExpressions);

        assertThat(postfixExpressions.size() == infixSize).isTrue();

        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(8));
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(2));
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.DIVISION);
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(3));
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.SUBTRACTION);
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(3));
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(2));
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.MULTIPLICATION);
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.ADDITION);
    }

    @Test
    void 연산자_우선순위에_맞게_변경한다() {
        final Queue<Expression> infixExpressions = new ArrayDeque<>();

        infixExpressions.add(new Operand(3));
        infixExpressions.add(Operator.ADDITION);
        infixExpressions.add(new Operand(2));
        infixExpressions.add(Operator.MULTIPLICATION);
        infixExpressions.add(new Operand(9));

        final int infixSize = infixExpressions.size();

        final Queue<Expression> postfixExpressions = postfixExpressionChanger.change(infixExpressions);

        assertThat(postfixExpressions.size() == infixSize).isTrue();

        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(3));
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(2));
        assertThat(postfixExpressions.poll()).isEqualTo(new Operand(9));
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.MULTIPLICATION);
        assertThat(postfixExpressions.poll()).isEqualTo(Operator.ADDITION);
    }
}