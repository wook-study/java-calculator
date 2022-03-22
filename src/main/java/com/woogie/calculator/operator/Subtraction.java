package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;

public class Subtraction implements Operable {
    @Override
    public Operand operate(Operand augend, Operand addend) {
        return new Operand(augend.getValue().add(addend.getValue().negate()));
    }
}
