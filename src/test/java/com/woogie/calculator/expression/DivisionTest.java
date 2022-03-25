package com.woogie.calculator.expression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

class DivisionTest {

    private Operable division;

    @BeforeEach
    void setUp() {
        division = new Division();
    }

    @Test
    void 두_정수를_입력받아_나눈다() {
        final Operand result = division.operate(new Operand(4), new Operand(2));

        assertThat(result).isEqualTo(new Operand(2));
    }

    @Test
    void 두_무리수를_입력받아_나눈다() {
        final Operand result = division.operate(new Operand(5.4), new Operand(3.4));

        assertThat(result).isEqualTo(new Operand(2));
    }

    @Test
    void 양수와_음수를_입력받아_나눈다() {
        final Operand result = division.operate(new Operand(3.1), new Operand(-3.4));

        assertThat(result).isEqualTo(new Operand(-1));
    }

    @Test
    void 스케일과_라운딩을_줘서_나누기() {
        final Operable division = new Division(2, RoundingMode.DOWN);

        final Operand result = division.operate(new Operand(7), new Operand(3));

        assertThat(result).isEqualTo(new Operand(2.33));
    }
}
