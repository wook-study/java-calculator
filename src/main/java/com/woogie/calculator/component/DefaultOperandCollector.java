package com.woogie.calculator.component;

import com.woogie.calculator.Arithmetic;
import com.woogie.calculator.operand.Operand;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DefaultOperandCollector implements OperandCollector {
    @Override
    public Stack<Operand> collect(final List<Arithmetic> arithmetics) {
        return arithmetics.stream()
                          .filter(it -> it instanceof Operand)
                          .map(it -> (Operand) it)
                          .collect(Collectors.toCollection(Stack::new));
    }
}
