package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;

public interface Operable {
    Operand operate(Operand augend, Operand addend);
}
