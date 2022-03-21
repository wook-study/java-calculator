package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionOperatorTest {

    @Test
    void 두_정수를_입력받아_더한다() {
        final Operable additionOperator = new AdditionOperator();

        final Operand result = additionOperator.execute(new Operand(2), new Operand(3));

        assertThat(result).isEqualTo(new Operand(5));
    }

    @Test
    void 두_무리수를_입력받아_더한다() {
        final Operable additionOperator = new AdditionOperator();

        final Operand result = additionOperator.execute(new Operand(1.3), new Operand(2.2));

        assertThat(result).isEqualTo(new Operand(3.5));
    }

    @Test
    void 양수와_음수를_입력받아_더한다() {
        final Operable additionOperator = new AdditionOperator();

        final Operand result = additionOperator.execute(new Operand(3.5), new Operand(-2.1));

        assertThat(result).isEqualTo(new Operand(1.4));
    }
}
