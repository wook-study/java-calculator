package com.woogie.calculator.domain.expression;

import com.woogie.calculator.domain.expression.Operand;
import com.woogie.calculator.domain.expression.Operable;

public class Multiplication implements Operable {
    @Override
    public Operand operate(Operand augend, Operand addend) {
        return new Operand(augend.getValue().multiply(addend.getValue()));
    }
}
