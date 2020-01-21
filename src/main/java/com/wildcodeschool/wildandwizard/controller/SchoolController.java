package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.repository.SchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SchoolController {

    private SchoolRepository repository = new SchoolRepository();

    @GetMapping("/school/delete")
    public String deleteWizard(@RequestParam Long id) {
    	
    	System.out.println("Bin im SchoolController, Methode deleteWizard");

        repository.deleteById(id);

        // Test: mal das "redirect:" weglassen
        // --> führt zu einer "org.thymeleaf.exceptions.TemplateInputException"
        // return "schools";
        
        return "redirect:/schools";
        
    }

    @GetMapping("/schools")
    public String getAll(Model model) {
    	
    	System.out.println("Bin im SchoolController, Methode getAll");

        model.addAttribute("schools", repository.findAll());

        return "school_get_all";
    }
}
