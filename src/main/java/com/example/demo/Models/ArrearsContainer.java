package com.example.demo.Models;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ArrearsContainer {
    /**
     * Instantiering af Relative klassen
     */
    private Relative relative;

    /**
     * Tom Constructor
     */
    public ArrearsContainer()
    {

    }

    //getters and setters
    public Relative getRelative() {
        return relative;
    }

    public void setRelative(Relative relative) {
        this.relative = relative;
    }



}
