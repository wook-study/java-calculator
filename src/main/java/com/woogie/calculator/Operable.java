package com.woogie.calculator;

import java.math.BigDecimal;

public interface Operable {
    BigDecimal execute(BigDecimal augend, BigDecimal addend);
}
