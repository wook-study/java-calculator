package com.woogie.calculator.component;

import com.woogie.calculator.domain.expression.Expression;

import java.util.Collection;
import java.util.List;

public interface ExpressionChanger {
    Collection<Expression> change(List<Expression> expressions);
}
