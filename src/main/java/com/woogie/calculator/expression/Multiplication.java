package com.woogie.calculator.expression;

/**
 * 곱셈 오퍼레이터
 */
public class Multiplication implements Operable {
    @Override
    public Operand operate(Operand augend, Operand addend) {
        return new Operand(augend.getValue().multiply(addend.getValue()));
    }
}
