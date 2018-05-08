package com.example.demo.Repository;

import com.example.demo.Interface.MødeInterface;
import com.example.demo.Models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepository implements MødeInterface {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Event get(int id) {
        String sql = "select * from Møder where mødeID = " + id;

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();

        Event ev = new Event(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5));

        return ev;
    }

    @Override
    public void delete(Event ev) {
        String sql = "Delete from Møder where mødeID =" + ev.geteventID();

        jdbc.update(sql);
    }

    @Override
    public List<Event> get() {

        List<Event> events = new ArrayList<>();
        String sql = "select * from Møder";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            events.add(new Event(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }
        System.out.println(events);
        return events;
    }


    @Override
    public void update(Event ev) {
        String sql = "Update Møder set " +
                "dato='" + ev.getDateString() + "', " +
                "tid='" + ev.getTid() + "', " +
                "beskrivelse='" + ev.getBeskrivelse() + "', " +
                "pladser=" + ev.getPladser() + " WHERE mødeID = " + ev.geteventID() + ";";
        System.out.println(sql);
        jdbc.update(sql);
    }

    @Override
    public void create(Event ev) {
        String sql = "insert into Møder(dato,tid,beskrivelse,pladser) " +
                "values('" +
                ev.getDateString() + "', '" +
                ev.getTid() + "', '" +
                ev.getBeskrivelse() + "', " +
                ev.getPladser() + ")";


        System.out.println(sql);

        jdbc.update(sql);


    }



}

