package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model){
        Person person = new Person();
        person.setName("Victor");
        person.setAge("24");
        person.setHeight("5'8");
        personRepository.save(person);
        model.addAttribute("persons",personRepository.findAll());
        return "index";
    }
    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        model.addAttribute("persons", personRepository.findByName(search));
        return "searchlist";
    }
}
