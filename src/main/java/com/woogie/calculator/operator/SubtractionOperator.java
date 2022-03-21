package com.woogie.calculator.operator;

import java.math.BigDecimal;

public class SubtractionOperator implements Operable {
    @Override
    public BigDecimal execute(BigDecimal augend, BigDecimal addend) {
        return augend.add(addend.negate());
    }
}
