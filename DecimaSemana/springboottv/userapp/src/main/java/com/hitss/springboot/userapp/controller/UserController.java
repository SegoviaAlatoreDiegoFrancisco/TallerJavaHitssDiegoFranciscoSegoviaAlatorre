package com.hitss.springboot.userapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller // se va  a recibir una vista (html)
public class UserController {
    @GetMapping("/details")
    public String details(Model model) {
        //        model.addAttribute("birthDate",LocalDate.pars);
        
        return "details";//nombre de la vista o plantilla (temolete), .html
    }
    @GetMapping("/user")
    //Model
    //Map
    //Model View
    public String user(Model model) {
        model.addAttribute("title", "Hola mundo SpringBoot3");
        model.addAttribute("name","Diego");
        model.addAttribute("lastname","Segovia");
        return "user";
    }
    
    
}
