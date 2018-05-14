package com.example.demo.Controllers;

import com.example.demo.Models.Relative;
import com.example.demo.Models.ViewPlaceholder;
import com.example.demo.Repository.RelativeEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class RelativeEventsController {
    @Autowired
    RelativeEventsRepository relativeEventsRepository;
    @Autowired
    RelativeController relativeController = new RelativeController();
    @Resource
    ViewPlaceholder viewPlaceholder;
    @Autowired
    EventController eventController = new EventController();

    /**
     * Get Event add html
     * @param idEv
     * @param model
     * @return String
     */
    @GetMapping("/event/add")
    public String addToEvent(@RequestParam("idEv") int idEv, Model model) {
        viewPlaceholder.setEvent(eventController.getDetails(idEv));
        model.addAttribute("Event", eventController.getDetails(idEv));
        model.addAttribute("Relative", new Relative());

        return "EventForm";
    }

    @PostMapping("/event/add")
    public String update(@ModelAttribute Relative rv){
        System.out.println(viewPlaceholder.getEvent());
        System.out.println(rv);
        Relative r = relativeController.relativeRepository.createNewRelative(rv);
        relativeEventsRepository.addToEvent(r.getRelatedID(), viewPlaceholder.getEvent().geteventID());
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

