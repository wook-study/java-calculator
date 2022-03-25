package com.woogie.calculator.parser;

/**
 * 정규표현식으로 문자열이 표현식으로 파싱할 수 있는지 검사
 */
public class RegExExpressionValidator implements ExpressionValidator<String> {
    @Override
    public boolean validate(final String s) {
        return s.matches("([0-9]*(\\s)([+\\-*/])(\\s)[0-9]+)+");
    }
}
