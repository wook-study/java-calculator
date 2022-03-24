package com.woogie.calculator.expression;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

/**
 * 피연산자
 */
public class Operand implements Expression {
    private final BigDecimal value;

    public Operand(double value) {
        this.value = BigDecimal.valueOf(value);
    }

    public Operand(BigDecimal value) {
        Optional.ofNullable(value).orElseThrow(IllegalArgumentException::new);

        this.value = value;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public BigDecimal getValue(int scale) {
        //noinspection BigDecimalMethodWithoutRoundingCalled
        return this.value.setScale(scale);
    }

    public BigDecimal getValue(int scale, RoundingMode roundingMode) {
        return this.value.setScale(scale, roundingMode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operand)) return false;
        Operand operand = (Operand) o;
        return Objects.equals(value.doubleValue(), operand.value.doubleValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value.doubleValue());
    }
}
