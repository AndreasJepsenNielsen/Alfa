package com.example.demo.Repository;

import com.example.demo.Interface.RelativeInterface;

import com.example.demo.Models.Relative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * RelativeRepository
 * Repository til relative
 */
@Repository
public class RelativeRepository implements RelativeInterface
{
    /**
     * Instantiering af JdcbTemplate
     */
    @Autowired
    private JdbcTemplate jdbc;

    /**
     * Metode som generer en Relative ud fra indtastet data
     * @param rs
     * @return Relative
     */

    private Relative generateRelative (SqlRowSet rs)
    {
        return new Relative(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
    }

    /**
     * Metode som generer en specific relative ud fra et indtastet id
     * @param id
     * @return Relative
     */
    public Relative getSpecific(int id) {
        String sql = "select * from v_relative where relativeID = " + id + ";";
        SqlRowSet rs = jdbc.queryForRowSet(sql);
        rs.next();
        Relative rv = new Relative(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

        return rv;
    }

    /**
     * Metode som returnerer en liste af alle Relative i tabellen Relative i sql databasen
     * @return List<Relative>
     */
    @Override
    public List<Relative> getList() {

        List<Relative> relatives = new ArrayList<>();
        String sql = "select * from Relative";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            relatives.add(new Relative(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }


        return relatives;
    }

    /**
     * Metode som opretter en relative ud fra det indtastede data
     * @param rv
     */
    @Override
    public void create(Relative rv)
    {
        String sql = "insert into Relative(firstName,lastName,email,phoneNumber)" +
                "values('" +
                rv.getFirstName() + "', '" +
                rv.getLastName() + "', '" +
                rv.getEmail() + "', " +
                rv.getPhoneNumber() + ")";




        jdbc.update(sql);
    }

    /**
     * Metode som sletter en Relative i både Relative tabellen og RelativeEvent tabellen i forhold
     * @param rv
     */
    @Override
    public void delete(Relative rv)
    {
        String sql = "Delete from Relative where relativeID =" + rv.getRelatedID();
        String sql2 = "Delete from RelativeEvent where relativeID=" + rv.getRelatedID();
        jdbc.update(sql2);
        jdbc.update(sql);
    }

    /**
     * Metode som opdaterer en Pårørende
     * @param rv
     */
    @Override
    public void update(Relative rv) {
        String sql = "Update Relative set " +
                "firstName='" + rv.getFirstName() + "', " +
                "lastName='" + rv.getLastName() + "', " +
                "email='" + rv.getEmail() + "', " +
                "phoneNumber=" + rv.getPhoneNumber() + " WHERE relativeID = " + rv.getRelatedID() + ";";
        jdbc.update(sql);
    }



    /**
     * Metode som laver en ny pårørende hvis pårørende ikke findes i vores database, hvis pårørende findes i databasen returnerer den pårørende
     * @param rv
     * @return Relative
     */
    public Relative createNewRelative(Relative rv)
    {
        String sql = "insert into Relative(firstName,lastName,email,phoneNumber) " +
                "values('" + rv.getFirstName() + "','" + rv.getLastName()  + "','" + rv.getEmail() + "'," + rv.getPhoneNumber() + ");";

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM Relative WHERE phoneNumber=" + rv.getPhoneNumber());
        if (rs.next()) {
            return generateRelative(rs);
        }
        else {
            jdbc.update(sql);
            rs = jdbc.queryForRowSet("SELECT * FROM Relative WHERE phoneNumber=" + rv.getPhoneNumber());
            rs.next();
            return generateRelative(rs);
        }
    }
}
