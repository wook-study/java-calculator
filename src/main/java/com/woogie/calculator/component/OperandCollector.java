package com.woogie.calculator.component;

import com.woogie.calculator.Arithmetic;
import com.woogie.calculator.operand.Operand;

import java.util.Collection;
import java.util.List;

public interface OperandCollector {
    Collection<Operand> collect(List<Arithmetic> arithmetics);
}
