package com.woogie.calculator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

class DivisionOperatorTest {

    @Test
    void 두_정수를_입력받아_나눈다() {
        final Operable divisionOperator = new DivisionOperator();

        final BigDecimal result = divisionOperator.execute(BigDecimal.valueOf(4), BigDecimal.valueOf(2));

        assertThat(result).isEqualTo(BigDecimal.valueOf(2));
    }

    @Test
    void 두_무리수를_입력받아_나눈다() {
        final Operable divisionOperator = new DivisionOperator();

        final BigDecimal result = divisionOperator.execute(BigDecimal.valueOf(5.4), BigDecimal.valueOf(3.4));

        assertThat(result).isEqualTo(BigDecimal.valueOf(2));
    }

    @Test
    void 양수와_음수를_입력받아_나눈다() {
        final Operable divisionOperator = new DivisionOperator();

        final BigDecimal result = divisionOperator.execute(BigDecimal.valueOf(3.1), BigDecimal.valueOf(-3.4));

        assertThat(result).isEqualTo(BigDecimal.valueOf(-1));
    }

    @Test
    void 스케일과_라운딩을_줘서_나누기() {
        final Operable divisionOperator = new DivisionOperator(2, RoundingMode.DOWN);

        final BigDecimal result = divisionOperator.execute(BigDecimal.valueOf(7), BigDecimal.valueOf(3));

        assertThat(result).isEqualTo(BigDecimal.valueOf(2.33));
    }
}
