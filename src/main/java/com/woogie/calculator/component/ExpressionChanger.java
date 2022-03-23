package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;

import java.util.Collection;
import java.util.Queue;

public interface ExpressionChanger {
    Collection<Expression> change(Queue<Expression> expressions);
}
