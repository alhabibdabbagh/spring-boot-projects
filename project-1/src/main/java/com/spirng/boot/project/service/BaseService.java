package com.spirng.boot.project.service;

import java.util.List;

/**
 * @author Habib
 * @on 9/24/21 - 8:42 AM
 */
public interface BaseService<T> {
    List<T> findAll();
    T findById(int id);
    String save(T object);
    void deleteById(int id);
    T updateEmployee(T t);
}
