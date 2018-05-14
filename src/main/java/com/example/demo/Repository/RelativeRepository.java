package com.example.demo.Repository;

import com.example.demo.Models.Relative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class RelativeRepository {
    @Autowired
    private JdbcTemplate jdbc;

    private Relative generateRelative (SqlRowSet rs)
    {
        return new Relative(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6));
    }

    public Relative getSpecific(int id) {
        return generateRelative(jdbc.queryForRowSet("select * from Relative where relativeID = " + id));
    }

    public boolean searchRelative(int pNo) {
        return jdbc.queryForRowSet("SELECT * FROM Relative WHERE phoneNumber =" + pNo) == null ? false: true;

        //short hand if statement
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
