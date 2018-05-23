package com.example.demo.Repository;

import com.example.demo.Interface.EventInterface;
import com.example.demo.Models.Event;
import com.example.demo.Models.Relative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * Repository til Event klassen som implementerer Eventinterface
 */
@Repository
public class EventRepository implements EventInterface {
    /**
     * Instantiering af jdbc som gør det muligt at lave en connection mellem java og Mysql
     */
    @Autowired
    private JdbcTemplate jdbc;


    /**
     * Metode overrider interface metoden med samme navn, laver en Sql string som skal finde eventID som svarer til det givne id
     * Laver et SqlRowSet som gør det muligt at henter hele Eventet som svarer til det givne id og tager rs.next for at gå videre til den næste row
     * Instantiere et nyt event og laver eventet ud fra dataen som findes i Sql databasen og returnerer til sidst eventet
     * Html->Database->Java
     * @param id
     * @return Event
     */
    @Override
    public Event getSpecific(int id) {
        String sql = "select * from v_event where eventID = " + id + ";";
        SqlRowSet rs = jdbc.queryForRowSet(sql);
        rs.next();
        Event ev = new Event(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5));

        return ev;
    }

    /**
     * Metode som sammenligner Relative.relativeID i databasen med Addict.relativeID for at finde dem som ikke sammensat med en misbruger
     * Ved brug af denne metode får vi en liste over dem som skal betale til møderne
     * @return List<Relative>
     */
    public List<Relative> getComparison()
    {
        List<Relative> listOfArrears = new ArrayList<>();


        String sql = "SELECT *\n" +
                "FROM Relative as r\n" +
                "WHERE r.relativeID not IN (select relativeID from Addict);";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next())
        {
         listOfArrears.add(new Relative(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
        }



        return listOfArrears;
    }


    /**
     * Metode som overrider interface metoden med samme navn, sletter det givne event som indeholder det pågældende id fra databasen
     * @param ev
     */
    @Override
    public void delete(Event ev) {
        String sql = "Delete from EventTable where eventID =" + ev.geteventID();
        String sql2 = "Delete from RelativeEvent where eventID=" + ev.geteventID();

        jdbc.update(sql2);
        jdbc.update(sql);
    }


    /**
     * Metode som overrider interface metoden med samme navn.
     * Metoden vælger alt fra EventTable og tilgår databasen via jdbc while loopet gør at den tilføjer nye
     * Events til listen så længe rs.next er true og returnerer til sidst listen med events
     * @return List<Event>
     */
    @Override
    public List<Event> getList() {

        List<Event> events = new ArrayList<>();
        String sql = "select * from EventTable";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            events.add(new Event(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }


        return events;
    }


    /**
     *Metode som opdaterer et event i Sql ud fra det pågældende id
     * @param ev
     */
    @Override
    public void update(Event ev) {
        String sql = "Update EventTable set " +
                "eventDate='" + ev.getDateString() + "', " +
                "eventTime='" + ev.getTime() + "', " +
                "description='" + ev.getDescription() + "', " +
                "slots=" + ev.getSlots() + " WHERE eventID = " + ev.geteventID() + ";";


        jdbc.update(sql);
    }


    /**
     * Metode som opretter et event i Sql databasen ud fra de specifikke values som bliver indskrevet i html formen
     * @param ev
     */
    @Override
    public void create(Event ev) {
        String sql = "insert into EventTable(eventDate,eventTime,description,slots) " +
                "values('" +
                ev.getDateString() + "', '" +
                ev.getTime() + "', '" +
                ev.getDescription() + "', " +
                ev.getSlots() + ")";



        jdbc.update(sql);
    }


}

