package com.woogie.calculator.expression;

public class Multiplication implements Operable {
    @Override
    public Operand operate(Operand augend, Operand addend) {
        return new Operand(augend.getValue().multiply(addend.getValue()));
    }
}
