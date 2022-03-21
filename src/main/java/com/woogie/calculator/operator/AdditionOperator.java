package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;

public class AdditionOperator implements Operable {
    @Override
    public Operand execute(final Operand augend, final Operand addend) {
        return new Operand(augend.getValue().add(addend.getValue()));
    }
}
