package com.example.demo.Controllers;

import com.example.demo.Models.Relative;
import com.example.demo.Repository.RelativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RelativeController {

    /**
     * Instantiering af relativerepository
     */
    @Autowired
    RelativeRepository relativeRepository = new RelativeRepository();




    /**
     * Getmapping til create metode
     * @param model
     * @return RelativeCreate.html
     */
   @GetMapping("/relative/create")
   public String create(Model model) {
       model.addAttribute("Relative", new Relative());
       return "RelativeCreate";
   }



    /**
     * Postmapping til ovenstående metode, efter man har indskrevet infoen til formen bliver den pårørende oprettet i databasen
     * @param rv
     * @return Relative.html
     */
    @PostMapping("/relative/create")
    public String create(@ModelAttribute Relative rv) {
            relativeRepository.create(rv);

        return "redirect:/relative";
    }


    /**
     * Finder relative ud fra specific id og returnerer relative til visuelt at kunne se det på html
     * @param id
     * @param model
     * @return RelativeUpdate
     */
    @GetMapping("/relative/update")
    public String update(@RequestParam("id") int id, Model model) {

        model.addAttribute("Relative", relativeRepository.getSpecific(id));

        return "RelativeUpdate";
    }


    /**
     * Opdaterer det specifikke event som findes i ovenstående metode
     * @param rv
     * @return Relative.html
     */
    @PostMapping("/relative/update")
    public String update(@ModelAttribute Relative rv) {
        relativeRepository.update(rv);
        return "redirect:/relative";
    }

    /**
     * Laver en liste ud fra alle værdierne i tabellen Relative fra databasen
     * @param model
     * @return Relative.html
     */
    @GetMapping("/relative")
    public String getRelatives(Model model){
        model.addAttribute("Relatives", relativeRepository.getList());
        return "Relative";
    }

    /**
     * metode som finder den pågældende pårørende i forhold til det givne id
     * @param id
     * @param model
     * @return RelativeDelete.html
     */
    @GetMapping("/relative/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("Relative",relativeRepository.getSpecific(id));
        return "RelativeDelete";
    }



    /**
     * Metode som sletter den specifikke pårørende som findes i den ovenstående metode
     * @param rv
     * @return Relative.html
     */
    @PostMapping("relative/delete")
    public String delete(@ModelAttribute Relative rv){
        relativeRepository.delete(rv);
        return "redirect:/relative";
    }

    /**
     * Metode som finder en specifik pårørende i forhold til et indtastet id
     * @param id
     * @param model
     * @return RelativeRead.html
     */
    @GetMapping("/relative/details")
    public String getDetails(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("Relative", relativeRepository.getSpecific(id));

        return "RelativeRead";
    }
}
