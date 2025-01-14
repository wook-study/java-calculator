package com.woogie.calculator.expression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {

    private Operable subtraction;

    @BeforeEach
    void setUp() {
        subtraction = new Subtraction();
    }

    @Test
    void 두_정수를_입력받아_뺀다() {
        final Operand result = subtraction.operate(new Operand(10), new Operand(3));

        assertThat(result).isEqualTo(new Operand(7));
    }

    @Test
    void 두_무리수를_입력받아_뺀다() {
        final Operand result = subtraction.operate(new Operand(3.5), new Operand(2.1));

        assertThat(result).isEqualTo(new Operand(1.4));
    }

    @Test
    void 작은양수와_큰양수를_입력받아_뺀다() {
        final Operand result = subtraction.operate(new Operand(3), new Operand(4));

        assertThat(result).isEqualTo(new Operand(-1));
    }

    @Test
    void 양수와_음수를_입력받아_뺀다() {
        final Operand result = subtraction.operate(new Operand(3.5), new Operand(-2.1));

        assertThat(result).isEqualTo(new Operand(5.6));
    }

    @Test
    void 음수와_음수를_입력받아_뺀다() {
        final Operand result = subtraction.operate(new Operand(-3.5), new Operand(-2.1));

        assertThat(result).isEqualTo(new Operand(-1.4));
    }
}
