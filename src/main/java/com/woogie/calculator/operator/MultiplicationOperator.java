package com.woogie.calculator.operator;

import java.math.BigDecimal;

public class MultiplicationOperator implements Operable {
    @Override
    public BigDecimal execute(BigDecimal augend, BigDecimal addend) {
        return augend.multiply(addend);
    }
}
