package com.woogie.calculator.operator;

import com.woogie.calculator.Arithmetic;

public enum Operator implements Arithmetic {
    OPENED_BRACE("("),
    CLOSED_BRACE(")"),
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String op;

    Operator(final String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }
}
