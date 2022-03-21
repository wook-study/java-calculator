package com.woogie.calculator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionOperatorTest {

    @Test
    void 두수를_입력받아_더한다() {
        AdditionOperator operator = new AdditionOperator();

        final BigDecimal result = operator.execute(BigDecimal.valueOf(2), BigDecimal.valueOf(3));

        assertThat(result).isEqualTo(BigDecimal.valueOf(5));
    }

    @Test
    void 정수가_아닌_두수를_입력받아_더한다() {
        AdditionOperator operator = new AdditionOperator();

        final BigDecimal result = operator.execute(BigDecimal.valueOf(1.3), BigDecimal.valueOf(2.2));

        assertThat(result).isEqualTo(BigDecimal.valueOf(3.5));
    }
}
