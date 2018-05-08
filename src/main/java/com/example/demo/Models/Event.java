package com.example.demo.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private int eventID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dato;
    private String tid;
    private String beskrivelse;
    private int pladser;

    public Event(int eventID, Date dato, String tid, String beskrivelse, int pladser) {
        this.eventID = eventID;
        this.dato = dato;
        this.tid = tid;
        this.beskrivelse = beskrivelse;
        this.pladser = pladser;
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




    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getPladser() {
        return pladser;
    }

    public void setPladser(int pladser) {
        this.pladser = pladser;
    }

    public String getDateString()
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(this.dato);
    }
}
