package com.woogie.calculator.parser;

/**
 * 제너릭으로 값을 받아 표현식으로 파싱할 수 있는지 검사
 */
public interface ExpressionValidator<T> {
    /**
     * 제너릭을 가지고 표현식으로 파싱할 수 있는지 검사
     */
    boolean validate(T t);
}
