package com.example.demo.Models;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ArrearsContainer {
    private Relative relative;

    public Relative getRelative() {
        return relative;
    }

    public void setRelative(Relative relative) {
        this.relative = relative;
    }

    public ArrearsContainer()
    {

    }


}
