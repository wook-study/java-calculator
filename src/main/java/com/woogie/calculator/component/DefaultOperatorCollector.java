package com.woogie.calculator.component;

import com.woogie.calculator.Arithmetic;
import com.woogie.calculator.operator.Operator;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DefaultOperatorCollector implements OperatorCollector {
    @Override
    public Stack<Operator> collect(final List<Arithmetic> arithmetics) {
        return arithmetics.stream()
                          .filter(it -> it instanceof Operator)
                          .map(it -> (Operator) it)
                          .collect(Collectors.toCollection(Stack::new));
    }
}
