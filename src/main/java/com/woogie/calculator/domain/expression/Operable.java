package com.woogie.calculator.domain.expression;

import com.woogie.calculator.domain.expression.Operand;

public interface Operable {
    Operand operate(Operand augend, Operand addend);
}
