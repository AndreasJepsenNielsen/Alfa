package com.example.demo.Models;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ViewPlaceholder {

    private Event event;

    public ViewPlaceholder() {

    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
