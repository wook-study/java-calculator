package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionOperatorTest {

    @Test
    void 두_정수를_입력받아_뺀다() {
        final Operable subtractionOperator = new SubtractionOperator();

        final Operand result = subtractionOperator.execute(new Operand(10), new Operand(3));

        assertThat(result).isEqualTo(new Operand(7));
    }

    @Test
    void 두_무리수를_입력받아_뺀다() {
        final Operable subtractionOperator = new SubtractionOperator();

        final Operand result = subtractionOperator.execute(new Operand(3.5), new Operand(2.1));

        assertThat(result).isEqualTo(new Operand(1.4));
    }

    @Test
    void 양수와_음수를_입력받아_뺀다() {
        final Operable subtractionOperator = new SubtractionOperator();

        final Operand result = subtractionOperator.execute(new Operand(3.5), new Operand(-2.1));

        assertThat(result).isEqualTo(new Operand(5.6));
    }
}
