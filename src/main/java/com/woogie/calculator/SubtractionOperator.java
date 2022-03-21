package com.woogie.calculator;

import java.math.BigDecimal;

public class SubtractionOperator implements Operable {
    @Override
    public BigDecimal execute(BigDecimal augend, BigDecimal addend) {
        return augend.add(addend.negate());
    }
}
