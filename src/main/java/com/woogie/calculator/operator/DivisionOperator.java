package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;

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
    public Operand execute(Operand augend, Operand addend) {
        return new Operand(augend.getValue().divide(addend.getValue(), scale, roundingMode));
    }
}
