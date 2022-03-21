package com.woogie.calculator.operator;

import java.util.stream.Stream;

public enum OperatorType {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String type;

    OperatorType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static OperatorType of(String type) {
        return Stream.of(values())
                .filter(it -> it.type.equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
