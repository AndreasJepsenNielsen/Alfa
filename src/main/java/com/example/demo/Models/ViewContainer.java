package com.example.demo.Models;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * ViewContainer klasse som gør det muligt, at gemme event dataen til brug i senere metode
 */
@Component
@Service
public class ViewContainer {
    /**
     * Instantiering af Event klassen
     */
    private Event event;



    /**
     * Tom constructor til klassen viewcontainer
     */
    public ViewContainer() {

    }

    //getters and setters
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
