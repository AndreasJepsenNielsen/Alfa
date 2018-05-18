package com.example.demo.Controllers;

import com.example.demo.Models.Event;
import com.example.demo.Models.Relative;
import com.example.demo.Repository.RelativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class RelativeController {
    //Instantiering af relativerepository
    @Autowired
    RelativeRepository relativeRepository = new RelativeRepository();

    //
    /*@GetMapping("/event/add")
    public String getDetails(@RequestParam("id") int id, Model model)
    {

        model.addAttribute("Relative", relativeRepository.getSpecific(id));
        return "Event";
    }*/

   /* Relative getRelative(int pNo){
        if(relativeRepository.searchRelative(pNo))
            return relativeRepository.getRelativeBy(pNo);
        return null;
    }
    */

   /*
    Relative getRelative(Relative rv){
        if(relativeRepository.searchRelative(rv.getPhoneNumber()))
            return relativeRepository.createNewRelative(rv);
        return null;
    }
*/
   @GetMapping("/relative/create")
   public String create(Model model) {
       model.addAttribute("Relative", new Relative());
       return "RelativeCreate";
   }

    //Postmapping til ovenstående metode, efter man har indskrevet infoen til formen bliver den pårørende oprettet i databasen
    @PostMapping("/relative/create")
    public String create(@ModelAttribute Relative rv) {
            relativeRepository.create(rv);

        return "redirect:/relative";
    }




    @GetMapping("/relative/update")
    public String update(@RequestParam("id") int id, Model model) {

        model.addAttribute("Relative", relativeRepository.getSpecific(id));

        return "RelativeUpdate";
    }

    //Opdaterer det specifikke event som findes i ovenstående metode
    @PostMapping("/relative/update")
    public String update(@ModelAttribute Relative rv) {
        relativeRepository.update(rv);
        return "redirect:/relative";
    }

    @GetMapping("/relative")
    public String getRelatives(Model model){
        model.addAttribute("Relatives", relativeRepository.getList());
        return "Relative";
    }

    //Delete
    @GetMapping("/relative/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("Relative",relativeRepository.getSpecific(id));
        return "RelativeDelete";
    }

    //Metode som sletter det specifikke id som findes i den ovenstående metode
    @PostMapping("relative/delete")
    public String delete(@ModelAttribute Relative rv){
        relativeRepository.delete(rv);
        return "redirect:/relative";
    }

    @GetMapping("/relative/details")
    public String getDetails(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("Relative", relativeRepository.getSpecific(id));

        return "RelativeRead";
    }
}
