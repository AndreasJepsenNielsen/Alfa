package com.example.demo.Repository;

import com.example.demo.Interface.EventInterface;
import com.example.demo.Models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepository implements EventInterface {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Event getSpecific(int id) {
        String sql = "select * from v_event where eventID = " + id + ";";
        System.out.println(sql);
        System.out.println("Get rowset");
        SqlRowSet rs = jdbc.queryForRowSet(sql);
        System.out.println("Finish yo");
        rs.next();

        Event ev = new Event(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5));

        return ev;
    }

    @Override
    public void delete(Event ev) {
        String sql = "Delete from EventTable where eventID =" + ev.geteventID();

        jdbc.update(sql);
    }

    @Override
    public List<Event> getList() {

        List<Event> events = new ArrayList<>();
        String sql = "select * from EventTable";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            events.add(new Event(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }
        System.out.println(events);
        return events;
    }


    @Override
    public void update(Event ev) {
        String sql = "Update EventTable set " +
                "eventDate='" + ev.getDateString() + "', " +
                "eventTime='" + ev.getTime() + "', " +
                "description='" + ev.getDescription() + "', " +
                "slots=" + ev.getSlots() + " WHERE eventID = " + ev.geteventID() + ";";
        System.out.println(sql);
        jdbc.update(sql);
    }

    @Override
    public void create(Event ev) {
        String sql = "insert into EventTable(eventDate,eventTime,description,slots) " +
                "values('" +
                ev.getDateString() + "', '" +
                ev.getTime() + "', '" +
                ev.getDescription() + "', " +
                ev.getSlots() + ")";


        System.out.println(sql);

        jdbc.update(sql);


    }


    public boolean searchEvent(int evId) {
        return jdbc.queryForRowSet("SELECT * FROM Event WHERE eventID =" + evId) == null ? false: true;

        //short hand if statement
    }


}

