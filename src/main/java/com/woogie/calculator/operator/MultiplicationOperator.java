package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;

public class MultiplicationOperator implements Operable {
    @Override
    public Operand execute(Operand augend, Operand addend) {
        return new Operand(augend.getValue().multiply(addend.getValue()));
    }
}
