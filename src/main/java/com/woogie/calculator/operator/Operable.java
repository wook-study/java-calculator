package com.woogie.calculator.operator;

import java.math.BigDecimal;

public interface Operable {
    BigDecimal execute(BigDecimal augend, BigDecimal addend);
}
