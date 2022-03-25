package com.woogie.calculator.expression;

/**
 * 연산처리를 할수있는 인터페이스
 * <p>
 * 해당 인터페이스를 구현해 연산 오퍼레이터를 만든다.
 */
public interface Operable {
    Operand operate(Operand augend, Operand addend);
}
