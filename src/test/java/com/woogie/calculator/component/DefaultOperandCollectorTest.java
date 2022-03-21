package com.woogie.calculator.component;

import com.woogie.calculator.operand.Operand;
import com.woogie.calculator.operator.Operator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultOperandCollectorTest {

    @Test
    void operand만_콜렉트한다() {
        final DefaultOperandCollector operandCollector = new DefaultOperandCollector();

        final Stack<Operand> operands = operandCollector.collect(
                List.of(new Operand(1), Operator.ADDITION, new Operand(3))
        );

        assertThat(operands).hasSize(2);
        assertThat(operands.pop()).isEqualTo(new Operand(3));
        assertThat(operands.pop()).isEqualTo(new Operand(1));
    }
}