package com.example.demo.Interface;


import java.util.List;

/**
 * SuperInterface tager imod generic type <T>
 * @param <T>
 */
public interface AlfaInterface <T>
{
    T getSpecific(int id);
    List<T> getList();
    void create(T entity);
    void delete(T entity);
    void update(T entity);
}