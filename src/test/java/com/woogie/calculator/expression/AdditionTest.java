package com.woogie.calculator.expression;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionTest {

    @Test
    void 두_정수를_입력받아_더한다() {
        final Operable addition = new Addition();

        final Operand result = addition.operate(new Operand(2), new Operand(3));

        assertThat(result).isEqualTo(new Operand(5));
    }

    @Test
    void 두_무리수를_입력받아_더한다() {
        final Operable addition = new Addition();

        final Operand result = addition.operate(new Operand(1.3), new Operand(2.2));

        assertThat(result).isEqualTo(new Operand(3.5));
    }

    @Test
    void 양수와_음수를_입력받아_더한다() {
        final Operable addition = new Addition();

        final Operand result = addition.operate(new Operand(3.5), new Operand(-2.1));

        assertThat(result).isEqualTo(new Operand(1.4));
    }
}