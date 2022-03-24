package com.woogie.calculator.component;

import com.woogie.calculator.expression.Expression;

import java.util.Collection;
import java.util.Queue;

/**
 * 표현식 변경 클래스
 */
public interface ExpressionChanger {
    /**
     * 큐에 저장된 표현식을 표현방식을 변경한다
     */
    Collection<Expression> change(Queue<Expression> expressions);
}
