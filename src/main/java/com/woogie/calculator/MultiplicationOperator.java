package com.woogie.calculator;

import java.math.BigDecimal;

public class MultiplicationOperator implements Operable {
    @Override
    public BigDecimal execute(BigDecimal augend, BigDecimal addend) {
        return augend.multiply(addend);
    }
}
