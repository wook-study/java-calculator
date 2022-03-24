package com.woogie.calculator.expression;

/**
 * 뺄셈 오퍼레이터
 */
public class Subtraction implements Operable {
    @Override
    public Operand operate(Operand augend, Operand addend) {
        return new Operand(augend.getValue().add(addend.getValue().negate()));
    }
}
