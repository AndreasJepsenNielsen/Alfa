package com.example.demo.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private int eventID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String time;
    private String description;
    private int slots;

    public Event(int eventID, Date date, String time, String description, int slots) {
        this.eventID = eventID;
        this.date = date;
        this.time = time;
        this.description = description;
        this.slots = slots;
    }

    public Event()
    {

    }

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

    public String getDateString()
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(this.date);
    }
}
