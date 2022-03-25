package com.woogie.calculator.repository;

import java.util.Collection;

public interface Repository<T> {
    T save(T t);

    Collection<T> findAll();
}
