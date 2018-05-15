package com.example.demo.Controllers;

import com.example.demo.Models.Relative;
import com.example.demo.Repository.RelativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/relative")
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
}
