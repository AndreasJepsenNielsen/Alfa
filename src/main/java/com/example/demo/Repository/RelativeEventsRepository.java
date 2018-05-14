package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RelativeEventsRepository {
    @Autowired
    private JdbcTemplate jdbc;


    public void addToEvent(int rvId, int evId)
    {
        String sql = "insert into RelativeEvent(relativeID,eventID) " +
                "values(" + rvId + ", " +
                evId + ")" ;
        System.out.println(sql);
        try {
            jdbc.update(sql);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR SPRIN.");
        }
    }
}
