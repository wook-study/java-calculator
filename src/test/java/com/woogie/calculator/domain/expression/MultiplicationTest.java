package com.woogie.calculator.domain.expression;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationTest {

    @Test
    void 두_정수를_입력받아_곱한다() {
        final Operable multiplication = new Multiplication();

        final Operand result = multiplication.operate(new Operand(3), new Operand(4));

        assertThat(result).isEqualTo(new Operand(12));
    }

    @Test
    void 두_무리수를_입력받아_곱한다() {
        final Operable multiplication = new Multiplication();

        final Operand result = multiplication.operate(new Operand(3.1), new Operand(3.4));

        assertThat(result).isEqualTo(new Operand(10.54));
    }

    @Test
    void 양수와_음수를_입력받아_곱한다() {
        final Operable multiplication = new Multiplication();

        final Operand result = multiplication.operate(new Operand(3.1), new Operand(-3.4));

        assertThat(result).isEqualTo(new Operand(-10.54));
    }
}