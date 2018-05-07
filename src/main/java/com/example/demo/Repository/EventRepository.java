package com.example.demo.Repository;

import com.example.demo.Interface.EventInterface;
import com.example.demo.Models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class EventRepository implements EventInterface{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Event get(int id) {
        return null;
    }

    @Override
    public List<Event> get() {
        return null;
    }

    @Override
    public void create(Event ev) {

    }

    @Override
    public void delete(Event ev) {

    }

    @Override
    public void update(Event ev) {

    }
}
