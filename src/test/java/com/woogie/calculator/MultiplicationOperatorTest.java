package com.woogie.calculator;

import com.woogie.calculator.operator.MultiplicationOperator;
import com.woogie.calculator.operator.Operable;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationOperatorTest {

    @Test
    void 두_정수를_입력받아_곱한다() {
        final Operable multiplicationOperator = new MultiplicationOperator();

        final BigDecimal result = multiplicationOperator.execute(BigDecimal.valueOf(3), BigDecimal.valueOf(4));

        assertThat(result).isEqualTo(BigDecimal.valueOf(12));
    }

    @Test
    void 두_무리수를_입력받아_곱한다() {
        final Operable multiplicationOperator = new MultiplicationOperator();

        final BigDecimal result = multiplicationOperator.execute(BigDecimal.valueOf(3.1), BigDecimal.valueOf(3.4));

        assertThat(result).isEqualTo(BigDecimal.valueOf(10.54));
    }

    @Test
    void 양수와_음수를_입력받아_곱한다() {
        final Operable multiplicationOperator = new MultiplicationOperator();

        final BigDecimal result = multiplicationOperator.execute(BigDecimal.valueOf(3.1), BigDecimal.valueOf(-3.4));

        assertThat(result).isEqualTo(BigDecimal.valueOf(-10.54));
    }
}
