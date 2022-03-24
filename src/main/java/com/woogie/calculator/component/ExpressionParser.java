package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;

import java.util.Collection;

/**
 * 제너릭을 받아 표현식으로 변경해주는 클래스
 */
public interface ExpressionParser<T> {
    /**
     * 제너릭을 받아 표현식 컬렉션으로 변경
     */
    Collection<Expression> parse(T t);
}
