package com.woogie.calculator.operand;

import com.woogie.calculator.Expression;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

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
        return value;
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
