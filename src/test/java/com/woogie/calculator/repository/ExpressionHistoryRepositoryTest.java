package com.woogie.calculator.repository;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionHistoryRepositoryTest {

    @Test
    void 표현식을_저장_성공() {
        final ExpressionHistoryRepository repository = new ExpressionHistoryRepository();

        repository.save("2 + 1");
        repository.save("3 * 4");
        repository.save("4 + 2");

        final List<String> foundExpressions = repository.findAll();

        assertThat(foundExpressions).hasSize(3);
        assertThat(foundExpressions).containsExactly("2 + 1", "3 * 4", "4 + 2");
    }
}