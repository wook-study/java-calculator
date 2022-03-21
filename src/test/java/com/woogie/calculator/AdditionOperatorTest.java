package com.woogie.calculator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionOperatorTest {

    @Test
    void 두_정수를_입력받아_더한다() {
        final Operable additionOperator = new AdditionOperator();

        final BigDecimal result = additionOperator.execute(BigDecimal.valueOf(2), BigDecimal.valueOf(3));

        assertThat(result).isEqualTo(BigDecimal.valueOf(5));
    }

    @Test
    void 두_무리수를_입력받아_더한다() {
        final Operable additionOperator = new AdditionOperator();

        final BigDecimal result = additionOperator.execute(BigDecimal.valueOf(1.3), BigDecimal.valueOf(2.2));

        assertThat(result).isEqualTo(BigDecimal.valueOf(3.5));
    }

    @Test
    void 양수와_음수를_입력받아_더한다() {
        final Operable additionOperator = new AdditionOperator();

        final BigDecimal result = additionOperator.execute(BigDecimal.valueOf(3.5), BigDecimal.valueOf(-2.1));

        assertThat(result).isEqualTo(BigDecimal.valueOf(1.4));
    }
}
