package com.example.demo.Interface;

import com.example.demo.Models.Event;

import java.util.List;

public interface EventInterface {
    Event get(int id);
    List<Event> get();
    void create(Event ev);
    void delete(Event ev);
    void update(Event ev);
}
