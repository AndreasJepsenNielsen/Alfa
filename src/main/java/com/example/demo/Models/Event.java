package com.example.demo.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private Date dato;
    private String tid;
    private String beskrivelse;

    public Event(Date dato, String tid, String beskrivelse, int pladser) {
        this.dato = dato;
        this.tid = tid;
        this.beskrivelse = beskrivelse;
        this.pladser = pladser;
    }

    public Event()
    {

    }

    private int pladser;

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
