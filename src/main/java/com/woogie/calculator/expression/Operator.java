package com.woogie.calculator.expression;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;

/**
 * 연산자
 */
public enum Operator implements Expression {
    ADDITION("+", 1, (augend, addend) -> new Addition().operate(augend, addend)),
    SUBTRACTION("-", 1, (augend, addend) -> new Subtraction().operate(augend, addend)),
    MULTIPLICATION("*", 0, (augend, addend) -> new Multiplication().operate(augend, addend)),
    DIVISION("/", 0, (augend, addend) -> new Division().operate(augend, addend));

    private final String code;
    private final int order;
    private final BiFunction<Operand, Operand, Operand> biFunction;

    Operator(final String code, int order, BiFunction<Operand, Operand, Operand> biFunction) {
        this.code = code;
        this.order = order;
        this.biFunction = biFunction;
    }

    public static Operator of(final String code) {
        return Arrays.stream(values())
                     .filter(it -> it.code.equals(code))
                     .findFirst()
                     .orElse(null);
    }

    public int getOrder() {
        return order;
    }

    public Operand calculate(Operand augend, Operand addend) {
        return biFunction.apply(augend, addend);
    }

    @Override
    public String toString() {
        return this.code;
    }
}
