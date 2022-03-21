package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;

public class SubtractionOperator implements Operable {
    @Override
    public Operand execute(Operand augend, Operand addend) {
        return new Operand(augend.getValue().add(addend.getValue().negate()));
    }
}
