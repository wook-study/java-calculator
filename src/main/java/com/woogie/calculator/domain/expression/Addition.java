package com.woogie.calculator.domain.expression;

public class Addition implements Operable {
    @Override
    public Operand operate(final Operand augend, final Operand addend) {
        return new Operand(augend.getValue().add(addend.getValue()));
    }
}
