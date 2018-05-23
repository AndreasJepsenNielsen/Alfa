package com.example.demo.Controllers;

import com.example.demo.Models.ArrearsContainer;
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
    /**
     * Instantiering af EventRepository
     */

    @Autowired
    private EventRepository eventRepository = new EventRepository();
    @Autowired
    ArrearsContainer arrearsContainer;



    /**
     * Metoder der får listen med alle Events
     * @param model
     * @return Event.html
     */
    @GetMapping("/event")
    public String getEvents(Model model){
        model.addAttribute("Events", eventRepository.getList());
        return "Event";
    }

    /**
     * //Metode som requester id, får det specifikke id og returnerer det event som svarer til id
     * @param id
     * @param model
     * @return EventRead.Html
     */

    @GetMapping("/event/details")
    public String getDetails(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("Event", eventRepository.getSpecific(id));
        
        return "EventRead";
    }

    /**
     * Finder det specifikke event som indeholder det givne id fra databasen
     * @param id
     * @return id
     */

    Event getDetails (int id) {
        return eventRepository.getSpecific(id);
    }

    /**
     * Event Create smider dig ind på eventCreate formen så der kan laves et nyt event
     * @param model
     * @return EventCreate.html
     */

    @GetMapping("/event/create")
    public String create(Model model) {
        model.addAttribute("Event", new Event());
        return "EventCreate";
    }


    /**
     * Postmapping til ovenstående metode, efter man har indskrevet infoen til formen bliver eventet oprettet i databasen
     * @param event
     * @param bindingResult
     * @return Event.html
     */
    @PostMapping("/event/create")
    public String create(@ModelAttribute Event event, BindingResult bindingResult) {

        eventRepository.create(event);


        return "redirect:/event";
    }

    /**
     * En metode som finder eventet der svarer til det givne id
     * @param id
     * @param model
     * @return EventDelete.html
     */
    @GetMapping("event/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("Event",eventRepository.getSpecific(id));
        return "EventDelete";
    }

    /**
     * Metode som sletter det specifikke id som findes i den ovenstående metode
     * @param ev
     * @return Event.html
     */
    @PostMapping("event/delete")
    public String delete(@ModelAttribute Event ev){
        eventRepository.delete(ev);
        return "redirect:/event";
    }

    /**
     * Metode som requester et id og returnerer det specifikke event
     * @param id
     * @param model
     * @return EventUpdate.html
     */
    @GetMapping("event/update")
    public String update(@RequestParam("id") int id, Model model) {

        model.addAttribute("Event", eventRepository.getSpecific(id));

        return "EventUpdate";
    }

    /**
     * Opdaterer det specifikke event som findes i ovenstående metode
     * @param ev
     * @return Event.html
     */
    @PostMapping("event/update")
    public String update(@ModelAttribute Event ev) {
        eventRepository.update(ev);
        return "redirect:/event";
    }

    /**
     * Metode som finder alle pårørende som skal betale i forhold til foreign key i Addict tabellen
     * @param model
     * @return EventArrears.html
     */

    @GetMapping("event/arrears")
    public String getArrears(Model model)
    {
        model.addAttribute("Relatives", eventRepository.getComparison());
        return "EventArrears";
    }


}
