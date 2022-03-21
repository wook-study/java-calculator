package com.woogie.calculator.component;

import com.woogie.calculator.operand.Operand;
import com.woogie.calculator.operator.Operator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultOperatorCollectorTest {

    @Test
    void operator만_콜렉트한다() {
        final DefaultOperatorCollector operatorCollector = new DefaultOperatorCollector();

        final Stack<Operator> operands = operatorCollector.collect(
                List.of(Operator.OPENED_BRACE, new Operand(1), Operator.ADDITION, new Operand(3), Operator.CLOSED_BRACE)
        );

        assertThat(operands).hasSize(3);
        assertThat(operands.pop()).isEqualTo(Operator.CLOSED_BRACE);
        assertThat(operands.pop()).isEqualTo(Operator.ADDITION);
        assertThat(operands.pop()).isEqualTo(Operator.OPENED_BRACE);
    }
}