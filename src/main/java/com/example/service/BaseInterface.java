package com.example.service;

import java.util.List;

public interface BaseInterface<T> {
    List<T> getAll();

    T getById(Integer id);

    void deleteById(Integer id);

    T creat(T item);

    T update(T item);
}