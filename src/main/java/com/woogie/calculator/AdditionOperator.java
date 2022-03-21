package com.woogie.calculator;

import java.math.BigDecimal;

public class AdditionOperator implements Operable {
    @Override
    public BigDecimal execute(final BigDecimal augend, final BigDecimal addend) {
        return augend.add(addend);
    }
}
