package com.example.demo.Controllers;

import com.example.demo.Models.Relative;
import com.example.demo.Models.ViewContainer;
import com.example.demo.Repository.RelativeEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class RelativeEventsController {
    //Instantiering af RelativeEventsRepository
    @Autowired
    private RelativeEventsRepository relativeEventsRepository;
    //Instantiering af RelativeController
    @Autowired
    RelativeController relativeController = new RelativeController();
    //Instantiering af viewContainer som indeholder data for vores Event
    @Resource
    ViewContainer viewContainer;
    //Instantiering af Eventcontroller
    @Autowired
    EventController eventController = new EventController();

    //En metode som henter formen til at tilføje en relative til et event, den indeholder også vores viewContainer som
    //holder på vores Event så det kan bruges i nedenstående metode
    @GetMapping("/event/add")
    public String addToEvent(@RequestParam("idEv") int idEv, Model model) {
        viewContainer.setEvent(eventController.getDetails(idEv));
        model.addAttribute("Event", eventController.getDetails(idEv));
        model.addAttribute("Relative", new Relative());

        return "EventForm";
    }

    //Metode tilføjer dataen som er indskrevet i ovenstående metode til databasen
    @PostMapping("/event/add")
    public String update(@ModelAttribute Relative rv){
        System.out.println(viewContainer.getEvent());
        System.out.println(rv);
        Relative r = relativeController.relativeRepository.createNewRelative(rv);
        relativeEventsRepository.addToEvent(r.getRelatedID(), viewContainer.getEvent().geteventID());

        return "redirect:/event/";
    }

/*
    @PostMapping("/event/addtodb")
    public String addToDB(@ModelAttribute Relative rv, @ModelAttribute Event event) {
            relativeEventsRepository.addToEvent(rv, event);

            return "redirect:/event";
    }
*/


}

