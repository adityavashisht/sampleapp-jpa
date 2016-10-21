package com.indasil.sampleapp.web;

import com.indasil.sampleapp.domain.Person;
import com.indasil.sampleapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by vashishta on 10/17/16.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public String show(Model model, @RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            model.addAttribute("person", personService.getById(id));
        }
        else {
            model.addAttribute("person", new Person());
        }
        /*Person person = personService.getById(id);
        model.addAttribute("person", person);*/
        return "data/person";
    }


    @ResponseBody
    @GetMapping(path = "/person/{id}")
    public ResponseEntity<Person> json(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(personService.getById(id), HttpStatus.OK);
    }


    @ResponseBody
    @PostMapping(path = "/person/save")
    public ResponseEntity<List<Person>> save(@ModelAttribute("person") Person person, BindingResult result) {
        personService.save(person);
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }


}
