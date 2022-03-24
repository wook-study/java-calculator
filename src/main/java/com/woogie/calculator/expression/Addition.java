package com.woogie.calculator.expression;

/**
 * 덧셈 오퍼레이터
 */
public class Addition implements Operable {
    @Override
    public Operand operate(final Operand augend, final Operand addend) {
        return new Operand(augend.getValue().add(addend.getValue()));
    }
}
