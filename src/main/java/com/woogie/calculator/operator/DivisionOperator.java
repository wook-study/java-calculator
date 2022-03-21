package com.woogie.calculator.operator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivisionOperator implements Operable {

    private final int scale;
    private final RoundingMode roundingMode;

    public DivisionOperator() {
        this.scale = 0;
        this.roundingMode = RoundingMode.HALF_UP;
    }

    public DivisionOperator(int scale, RoundingMode roundingMode) {
        this.scale = scale;
        this.roundingMode = roundingMode;
    }

    @Override
    public BigDecimal execute(BigDecimal augend, BigDecimal addend) {
        return augend.divide(addend, scale, roundingMode);
    }
}
