package com.example.demo.Interface;

import com.example.demo.Models.Event;
import com.example.demo.Models.Relative;

import java.util.List;

public interface AlfaInterface <T>
{
    T getSpecific(int id);
    List<T> getList();
    void create(T entity);
    void delete(T entity);
    void update(T entity);
}