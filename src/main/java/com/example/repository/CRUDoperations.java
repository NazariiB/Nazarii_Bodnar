package com.example.repository;

import java.util.List;

public interface CRUDoperations<T> {
    List<T> getAll();

    T getById(Integer id);

    void deleteById(Integer id);

    T creat(T item);

    T update(T item);
}