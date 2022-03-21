package com.woogie.calculator.component;

import com.woogie.calculator.Arithmetic;
import com.woogie.calculator.operator.Operator;

import java.util.Collection;
import java.util.List;

public interface OperatorCollector {
    Collection<Operator> collect(List<Arithmetic> arithmetics);
}
