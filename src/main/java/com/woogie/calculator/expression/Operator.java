package com.woogie.calculator.expression;

import java.util.function.BiFunction;

public enum Operator implements Expression {
    ADDITION("+", (augend, addend) -> new Addition().operate(augend, addend)),
    SUBTRACTION("-", (augend, addend) -> new Subtraction().operate(augend, addend)),
    MULTIPLICATION("*", (augend, addend) -> new Multiplication().operate(augend, addend)),
    DIVISION("/", (augend, addend) -> new Division().operate(augend, addend));

    private final String code;

    private final BiFunction<Operand, Operand, Operand> biFunction;

    Operator(final String code, BiFunction<Operand, Operand, Operand> biFunction) {
        this.code = code;
        this.biFunction = biFunction;
    }

    public String getCode() {
        return code;
    }

    public Operand calculate(Operand augend, Operand addend) {
        return biFunction.apply(augend, addend);
    }
}
