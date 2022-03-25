package com.woogie.calculator.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpressionHistoryRepository implements Repository<String> {

    private final List<String> expressions;

    public ExpressionHistoryRepository() {
        this.expressions = new ArrayList<>();
    }

    @Override
    public String save(final String expression) {
        this.expressions.add(expression);

        return expression;
    }

    @Override
    public List<String> findAll() {
        return Collections.unmodifiableList(this.expressions);
    }
}
