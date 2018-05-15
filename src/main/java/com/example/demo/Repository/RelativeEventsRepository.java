package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//Repository til RelativeEvent bruges som en mellem klasse mellem relative og Events
@Repository
public class RelativeEventsRepository {
    //Instantiering af jdbc template
    @Autowired
    private JdbcTemplate jdbc;

    //En metode som tilføjer en relativeId og eventId til Sql databasen
    public void addToEvent(int rvId, int evId)
    {
        String sql = "insert into RelativeEvent(relativeID,eventID) " +
                "values(" + rvId + ", " +
                evId + ")" ;
        System.out.println(sql);

            jdbc.update(sql);

    }
}
