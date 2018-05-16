package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
/*
   public List<String> getEventRelatives(int evId){

       List<String> signups = new ArrayList<>();

       String sql = "select Relative.firstName, Relative.lastName " +
               "from Relative, RelativeEvent, EventTable " +
               "where Relative.relativeID = RelativeEvent.relativeID " +
               "and " + evId + " = RelativeEvent.eventID";

       SqlRowSet rs = jdbc.queryForRowSet(sql);

       while (rs.next()){
           signups.add(rs.getString(1) + " " + rs.getString(2));
       }

     return signups;

    }
    */

}
