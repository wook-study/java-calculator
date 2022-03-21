package com.woogie.calculator;

import com.woogie.calculator.operator.Operable;
import com.woogie.calculator.operator.SubtractionOperator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionOperatorTest {

    @Test
    void 두_정수를_입력받아_뺀다() {
        final Operable subtractionOperator = new SubtractionOperator();

        final BigDecimal result = subtractionOperator.execute(BigDecimal.valueOf(10), BigDecimal.valueOf(3));

        assertThat(result).isEqualTo(BigDecimal.valueOf(7));
    }

    @Test
    void 두_무리수를_입력받아_뺀다() {
        final Operable subtractionOperator = new SubtractionOperator();

        final BigDecimal result = subtractionOperator.execute(BigDecimal.valueOf(3.5), BigDecimal.valueOf(2.1));

        assertThat(result).isEqualTo(BigDecimal.valueOf(1.4));
    }

    @Test
    void 양수와_음수를_입력받아_뺀다() {
        final Operable subtractionOperator = new SubtractionOperator();

        final BigDecimal result = subtractionOperator.execute(BigDecimal.valueOf(3.5), BigDecimal.valueOf(-2.1));

        assertThat(result).isEqualTo(BigDecimal.valueOf(5.6));
    }
}
