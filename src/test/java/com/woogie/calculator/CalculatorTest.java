package com.woogie.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 두수를_입력받아_더한다() {
        Calculator calculator = new Calculator();

        final int result = calculator.sum(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 정수가_아닌_두수를_입력받아_더한다() {
        Calculator calculator = new Calculator();

        final int result = calculator.sum(1.3, 2.2);

        assertThat(result).isEqualTo(3);
    }
}