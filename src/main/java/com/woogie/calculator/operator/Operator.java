package com.woogie.calculator.operator;

import com.woogie.calculator.Expression;

public enum Operator implements Expression {
    OPENED_BRACE("("),
    CLOSED_BRACE(")"),
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String code;

    Operator(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
