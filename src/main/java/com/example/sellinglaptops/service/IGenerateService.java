package com.example.sellinglaptops.service;

import java.util.Optional;

public interface IGenerateService<T>{
    Iterable<T> findAll();
    Optional<T> findById(long id);
    T save(T t);
    void remove(long id);
}
