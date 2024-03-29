package com.example.productmanagement.service;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();

    T findById(Long id);

    T save(T t);

    void remove(Long id);
}
