package com.example.demo.Controllers;

import com.example.demo.Models.Event;
import com.example.demo.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EventController {
    @Autowired
    EventRepository eventRepository = new EventRepository();





}
