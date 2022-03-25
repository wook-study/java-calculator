package com.woogie.calculator.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegExExpressionValidatorTest {

    private RegExExpressionValidator expressionValidator;

    @BeforeEach
    void setUp() {
        expressionValidator = new RegExExpressionValidator();
    }

    @Test
    void 표현식으로_파싱_가능_하면__true() {
        final String expression = "1 + 2 * 3";

        final boolean result = expressionValidator.validate(expression);

        assertThat(result).isTrue();
    }

    @Test
    void 표현식으로_파싱_불가능_하면__false__연산자가_두_번_올_수_없음() {
        final String expression = "1 + 2 * * 3";

        final boolean result = expressionValidator.validate(expression);

        assertThat(result).isFalse();
    }

    @Test
    void 표현식으로_파싱_불가능_하면__false__공백이_두_번_올_수_없음() {
        final String expression = "1 + 2 *  3";

        final boolean result = expressionValidator.validate(expression);

        assertThat(result).isFalse();
    }

    @Test
    void 표현식으로_파싱_불가능_하면__false__숫자가_두_번_올_수_없음() {
        final String expression = "1 4 + 2 * 3";

        final boolean result = expressionValidator.validate(expression);

        assertThat(result).isFalse();
    }

    @Test
    void 표현식으로_파싱_불가능_하면__false__공백으로_구분() {
        final String expression = "1+ 2 * 3";

        final boolean result = expressionValidator.validate(expression);

        assertThat(result).isFalse();
    }

    @Test
    void 표현식으로_파싱_불가능_하면__false_문자_허용하지않음() {
        final String expression = "1 + 2 * 3 갈";

        final boolean result = expressionValidator.validate(expression);

        assertThat(result).isFalse();
    }

    @Test
    void 표현식으로_파싱_불가능_하면__false_허용된_연산자만_사용가능() {
        final String expression = "1 + 2 * 3 ^ 2";

        final boolean result = expressionValidator.validate(expression);

        assertThat(result).isFalse();
    }
}