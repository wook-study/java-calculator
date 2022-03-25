package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.expression.Operator;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixCalculatorTest {

    @Test
    void 후위표현식으로_계산한다() {
        final Calculatable<Queue<Expression>> postfixCalculator = new PostfixCalculator();

        final Queue<Expression> expressions = new ArrayDeque<>();
        expressions.add(new Operand(8));
        expressions.add(new Operand(2));
        expressions.add(Operator.DIVISION);
        expressions.add(new Operand(3));
        expressions.add(Operator.SUBTRACTION);
        expressions.add(new Operand(3));
        expressions.add(new Operand(2));
        expressions.add(Operator.MULTIPLICATION);
        expressions.add(Operator.ADDITION);

        final Operand operand = postfixCalculator.calculate(expressions);

        assertThat(operand).isEqualTo(new Operand(7));
    }

    @Test
    void 연산_우선순위에_맞게_계산한다() {
        final Calculatable<Queue<Expression>> postfixCalculator = new PostfixCalculator();

        final Queue<Expression> expressions = new ArrayDeque<>();
        expressions.add(new Operand(3));
        expressions.add(new Operand(4));
        expressions.add(new Operand(4));
        expressions.add(Operator.MULTIPLICATION);
        expressions.add(Operator.ADDITION);

        final Operand operand = postfixCalculator.calculate(expressions);

        assertThat(operand).isEqualTo(new Operand(19));
    }
}
