package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;

import java.util.Collection;

/**
 * 표현식을 받아 연산처리
 */
public interface Calculatable<T extends Collection<Expression>> {
    /**
     * 컬렉션을 구현한 표현식을 받아 연산한다
     */
    Operand calculate(T expressions);
}
