package com.woogie.calculator.expression;

public interface Operable {
    Operand operate(Operand augend, Operand addend);
}
