package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;

import java.util.Collection;

/**
 * String 을 받아 표현식으로 변경해주는 클래스
 */
public class StringToExpressionParser<T> implements ExpressionParser<String> {
    @Override
    public Collection<Expression> parse(String s) {
        return null;
    }
}
