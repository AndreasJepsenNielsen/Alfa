package com.example.demo.Controllers;

import com.example.demo.Models.Event;
import com.example.demo.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventController {
    //Instantiering af EventRepository
    @Autowired
    private EventRepository eventRepository = new EventRepository();

    //Metoder der får listen med alle Events
    @GetMapping("/event")
    public String getEvents(Model model){
        model.addAttribute("Events", eventRepository.getList());
        return "Event";
    }

    //Metode som requester id, får det specifikke id og returnerer det event som svarer til id
    @GetMapping("/event/details")
    public String getDetails(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("Event", eventRepository.getSpecific(id));
        
        return "EventRead";
    }

    //Finder det specifikke event som indeholder det givne id fra databasen
    Event getDetails (int id) {
        return eventRepository.getSpecific(id);
    }

    //Event Create smider dig ind på eventCreate formen så der kan laves et nyt event
    @GetMapping("/event/create")
    public String create(Model model) {
        model.addAttribute("Event", new Event());
        return "EventCreate";
    }

    //Postmapping til ovenstående metode, efter man har indskrevet infoen til formen bliver eventet oprettet i databasen
    @PostMapping("/event/create")
    public String create(@ModelAttribute Event event, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()){
        System.out.println(event);
        eventRepository.create(event);}
        else
            System.out.println(bindingResult);

        return "redirect:/event";
    }

    //En metode som finder eventet der svarer til det givne id
    @GetMapping("event/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("Event",eventRepository.getSpecific(id));
        return "EventDelete";
    }

    //Metode som sletter det specifikke id som findes i den ovenstående metode
    @PostMapping("event/delete")
    public String delete(@ModelAttribute Event ev){
        eventRepository.delete(ev);
        return "redirect:/event";
    }

    //Metode som requester et id og returnerer det specifikke event
    @GetMapping("event/update")
    public String update(@RequestParam("id") int id, Model model) {

        model.addAttribute("Event", eventRepository.getSpecific(id));

        return "EventUpdate";
    }

    //Opdaterer det specifikke event som findes i ovenstående metode
    @PostMapping("event/update")
    public String update(@ModelAttribute Event ev) {
        eventRepository.update(ev);
        return "redirect:/event";
    }

  /*  Event getEvents(Event event){


        return event;
    }
    */
}
