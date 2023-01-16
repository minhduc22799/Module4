package com.example.validateform.service;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll() throws Exception;

    Optional<T> findById(Long id) throws Exception;

    void save(T t) throws DuplicateEmailException;

    void remove(Long id);
}
