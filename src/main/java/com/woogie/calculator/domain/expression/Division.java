package com.woogie.calculator.domain.expression;

import java.math.RoundingMode;

public class Division implements Operable {

    private final int scale;
    private final RoundingMode roundingMode;

    public Division() {
        this.scale = 0;
        this.roundingMode = RoundingMode.HALF_UP;
    }

    public Division(int scale, RoundingMode roundingMode) {
        this.scale = scale;
        this.roundingMode = roundingMode;
    }

    @Override
    public Operand operate(Operand augend, Operand addend) {
        return new Operand(augend.getValue().divide(addend.getValue(), scale, roundingMode));
    }
}
