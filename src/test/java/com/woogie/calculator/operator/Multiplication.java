package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;

public class Multiplication implements Operable {
    @Override
    public Operand operate(Operand augend, Operand addend) {
        return new Operand(augend.getValue().multiply(addend.getValue()));
    }
}
