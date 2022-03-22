package com.woogie.calculator.domain.expression;

import com.woogie.calculator.domain.expression.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class OperandTest {

    @Test
    void operand를_생성할_수_있다() {
        final Operand operand = new Operand(3.5);

        assertThat(operand.getValue()).isEqualTo(BigDecimal.valueOf(3.5));
    }
}