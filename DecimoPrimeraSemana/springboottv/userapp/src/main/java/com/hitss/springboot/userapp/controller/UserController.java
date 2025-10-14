package com.hitss.springboot.userapp.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.hitss.springboot.userapp.models.User;




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
        User user = new User("Diego", "Segovia", LocalDate.parse("1999-08-05"));
        model.addAttribute("title", "Hola mundo SpringBoot3");        
        model.addAttribute("user",user);
        //model.addAttribute("lastname","Segovia");
        return "user";
    }
    @GetMapping("/list")
    public String listUsers(ModelMap model) {
        //User user1 = new User("Diego", "Segovia", LocalDate.parse("1999-08-05"));
        //User user2 = new User("Diego", "Segovia", LocalDate.parse("1999-08-05"));
        //User user3 = new User("Diego", "Segovia", LocalDate.parse("1999-08-05"));
        
       // List<User> users = new ArrayList<>(List.of(user1, user2, user3));
        
        return "list";
    }
    
    
    
}
