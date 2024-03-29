package com.example.customer.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);
    T save1(T t);

    void remove(Long id);
}
