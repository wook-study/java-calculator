package com.woogie.calculator.expression;

import java.util.function.BiFunction;

public enum Operator implements Expression {
    ADDITION("+", 0, (augend, addend) -> new Addition().operate(augend, addend)),
    SUBTRACTION("-", 0, (augend, addend) -> new Subtraction().operate(augend, addend)),
    MULTIPLICATION("*", 1, (augend, addend) -> new Multiplication().operate(augend, addend)),
    DIVISION("/", 1, (augend, addend) -> new Division().operate(augend, addend));

    private final String code;
    private final int order;
    private final BiFunction<Operand, Operand, Operand> biFunction;

    Operator(final String code, int order, BiFunction<Operand, Operand, Operand> biFunction) {
        this.code = code;
        this.order = order;
        this.biFunction = biFunction;
    }

    public Operand calculate(Operand augend, Operand addend) {
        return biFunction.apply(augend, addend);
    }

    public boolean priority(Operator operator) {
        return this.order > operator.order;
    }
}
