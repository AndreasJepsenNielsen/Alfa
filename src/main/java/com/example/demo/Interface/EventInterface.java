package com.example.demo.Interface;

import com.example.demo.Models.Event;

import java.util.List;

public interface EventInterface {
    Event getSpecific(int id);
    List<Event> getList();
    void create(Event ev);
    void delete(Event ev);
    void update(Event ev);
}
