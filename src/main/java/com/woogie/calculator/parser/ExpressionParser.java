package com.woogie.calculator.parser;

import com.woogie.calculator.expression.Expression;

import java.util.Collection;

/**
 * 제너릭을 받아 표현식으로 파싱해주는 클래스
 */
public interface ExpressionParser<T> {
    /**
     * 제너릭을 받아 표현식 컬렉션으로 파싱
     */
    Collection<Expression> parse(T t);
}
