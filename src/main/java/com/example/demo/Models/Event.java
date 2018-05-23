package com.example.demo.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Klasse som definerer objektet Event
 */
public class Event {
    //Attributes
    private int eventID;
    //Beskriver formatet for date så det kan indskrives i sql databasen

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String time;
    private String description;
    private int slots;



    /**
     * Constructor til Klassen Event
     * @param eventID
     * @param date
     * @param time
     * @param description
     * @param slots
     */
    public Event(int eventID, Date date, String time, String description, int slots) {
        this.eventID = eventID;
        this.date = date;
        this.time = time;
        this.description = description;
        this.slots = slots;
    }

    /**
     * Tom Constructor
     */
    public Event()
    {
    }

    //Metode til at formatere vores date til det rigtige format som sql tager imod

    /**
     * Metode til at formatere vores java.util.date til et format som Sql modtager.
     * @return String
     */
    public String getDateString()
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(this.date);
    }

    //Getters and Setters
    public int geteventID() {
        return eventID;
    }

    public void seteventID(int eventID) {
        this.eventID = eventID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }


}
