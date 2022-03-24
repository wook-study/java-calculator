package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;
import com.woogie.calculator.expression.Operand;
import com.woogie.calculator.expression.Operator;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringToExpressionParserTest {

    private final ExpressionParser<String> expressionParser = new StringToExpressionParser(new RegExExpressionValidator());

    @Test
    void 문자열을_표현식으로_파싱_성공() {
        final String expression = "1 + 2 * 3";

        final Collection<Expression> parsedExpressions = expressionParser.parse(expression);

        assertThat(parsedExpressions)
                .containsExactly(new Operand(1), Operator.ADDITION, new Operand(2), Operator.MULTIPLICATION, new Operand(3));
    }

    @Test
    void 허용하지않는_식은_표현식으로_파싱불가능() {
        final String expression = "1 + + 2 * 3";

        assertThatIllegalArgumentException().isThrownBy(() -> expressionParser.parse(expression));
    }
}