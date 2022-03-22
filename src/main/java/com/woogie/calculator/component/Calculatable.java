package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;

import java.util.Collection;

public interface Calculatable<T extends Collection<Expression>> {
    Operand calculate(T expressions);
}
