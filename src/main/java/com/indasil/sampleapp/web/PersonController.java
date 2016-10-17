package com.indasil.sampleapp.web;

import com.indasil.sampleapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Created by vashishta on 10/17/16.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public String show(Model model, @RequestParam(value = "id", required = false) Long id) {
        model.addAttribute("person", personService.getById(id));

        return "data/person";
    }
}
