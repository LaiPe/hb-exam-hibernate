package com.humanbooster.dao;

import java.util.List;

public interface GenericDAO<T,ID> {
    void create(T entity);
    T read(ID id);
    void update(T entity);
    void delete(ID id);

    List<T> readAll();
}
