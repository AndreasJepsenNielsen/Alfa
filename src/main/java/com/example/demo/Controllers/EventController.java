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
    @Autowired
    EventRepository eventRepository = new EventRepository();

    @GetMapping("/event")
    public String Event(Model model){
        model.addAttribute("Events", eventRepository.get());
        return "Event";
    }

    @GetMapping("/event/details")
    public String details(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("Event", eventRepository.get(id));
        return "EventRead";
    }


    @GetMapping("/event/create")
    public String create(Model model) {
        model.addAttribute("Event", new Event());
        return "EventCreate";
    }

    @PostMapping("/event/create")
    public String create(@ModelAttribute Event event, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()){
        System.out.println(event);
        eventRepository.create(event);}
        else
            System.out.println(bindingResult);

        return "redirect:/event";
    }

    @GetMapping("event/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("Event",eventRepository.get(id));
        return "EventDelete";
    }

    @PostMapping("event/delete")
    public String delete(@ModelAttribute Event ev){
        eventRepository.delete(ev);
        return "redirect:/event";
    }


    @GetMapping("event/update")
    public String update(@RequestParam("id") int id, Model model) {

        model.addAttribute("Event", eventRepository.get(id));

        return "EventUpdate";
    }

    @PostMapping("event/update")
    public String update(@ModelAttribute Event ev) {
        eventRepository.update(ev);
        return "redirect:/event";
    }



}
