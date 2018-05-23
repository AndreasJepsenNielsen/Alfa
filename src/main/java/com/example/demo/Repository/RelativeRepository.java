package com.example.demo.Repository;

import com.example.demo.Interface.AlfaInterface;
import com.example.demo.Interface.RelativeInterface;
import com.example.demo.Models.Event;
import com.example.demo.Models.Relative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * RelativeRepository
 * @ref EventRepository
 * @Documentation for methods with no comments is in above referenced class
 */
@Repository
public class RelativeRepository implements RelativeInterface
{
    @Autowired
    private JdbcTemplate jdbc;

    /**
     * blaalsdas
     * @param rs
     * @return Relative
     */
    private Relative generateRelative (SqlRowSet rs)
    {
        return new Relative(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
    }

    public Relative getSpecific(int id) {
        String sql = "select * from v_relative where relativeID = " + id + ";";
        SqlRowSet rs = jdbc.queryForRowSet(sql);
        rs.next();
        Relative rv = new Relative(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

        return rv;
    }


    @Override
    public List<Relative> getList() {

        List<Relative> relatives = new ArrayList<>();
        String sql = "select * from Relative";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            relatives.add(new Relative(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }
        System.out.println(relatives);

        return relatives;
    }

    @Override
    public void create(Relative rv)
    {
        String sql = "insert into Relative(firstName,lastName,email,phoneNumber)" +
                "values('" +
                rv.getFirstName() + "', '" +
                rv.getLastName() + "', '" +
                rv.getEmail() + "', " +
                rv.getPhoneNumber() + ")";


        System.out.println(sql);

        jdbc.update(sql);
    }

    @Override
    public void delete(Relative rv)
    {
        String sql = "Delete from Relative where relativeID =" + rv.getRelatedID();
        String sql2 = "Delete from RelativeEvent where relativeID=" + rv.getRelatedID();
        jdbc.update(sql2);
        jdbc.update(sql);
    }

    @Override
    public void update(Relative rv) {
        String sql = "Update Relative set " +
                "firstName='" + rv.getFirstName() + "', " +
                "lastName='" + rv.getLastName() + "', " +
                "email='" + rv.getEmail() + "', " +
                "phoneNumber=" + rv.getPhoneNumber() + " WHERE relativeID = " + rv.getRelatedID() + ";";
        System.out.println(sql);
        jdbc.update(sql);
    }
    //short hand if statement
    public boolean searchRelative(int pNo) {
        return jdbc.queryForRowSet("SELECT * FROM Relative WHERE phoneNumber =" + pNo) == null ? false: true;

    }

    public Relative createNewRelative(Relative rv)
    {
        String sql = "insert into Relative(firstName,lastName,email,phoneNumber) " +
                "values('" + rv.getFirstName() + "','" + rv.getLastName()  + "','" + rv.getEmail() + "'," + rv.getPhoneNumber() + ");";

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM Relative WHERE phoneNumber=" + rv.getPhoneNumber());
        if (rs.next()) {
            System.out.println("Not Found");
            return generateRelative(rs);
        }
        else {
            jdbc.update(sql);
            rs = jdbc.queryForRowSet("SELECT * FROM Relative WHERE phoneNumber=" + rv.getPhoneNumber());
            rs.next();
            System.out.println("found");
            return generateRelative(rs);
        }
    }
}
