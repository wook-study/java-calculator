package com.woogie.calculator.operator;

import com.woogie.calculator.operand.Operand;

public interface Operable {
    Operand execute(Operand augend, Operand addend);
}
