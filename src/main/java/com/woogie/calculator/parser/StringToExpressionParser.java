package com.woogie.calculator.parser;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.expression.Operator;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * String 을 받아 표현식으로 파싱해주는 클래스
 */
public class StringToExpressionParser implements ExpressionParser<String> {
    private final ExpressionValidator<String> validator;

    public StringToExpressionParser(final ExpressionValidator<String> validator) {this.validator = validator;}

    @Override
    public Queue<Expression> parse(String expression) {
        if (!validator.validate(expression)) {
            throw new IllegalArgumentException("잘못된 수식\n피연산자 + 연산자 + 피연산자");
        }

        return Stream.of(expression.split(" "))
                     .map(it -> Optional.of(it)
                                        .map(expr -> (Expression) Operator.of(expr))
                                        .orElseGet(() -> new Operand(new BigDecimal(it))))
                     .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
