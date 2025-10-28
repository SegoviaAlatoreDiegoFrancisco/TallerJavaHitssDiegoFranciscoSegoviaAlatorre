package com.hitss.springboot.userapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.hitss.springboot.userapp.models.User;




@Controller //se va a recibir una vista en HTML
public class UserController {

    @GetMapping("/details")  //nombre en la direccion  
    public String details(Model model) {
        User user = new User("Francisco", "Segovia",LocalDate.parse("2025-05-08"));
        user.setEmail("segovia@gmail.com");        
        model.addAttribute("title", "Hola Mundo! ...desde userController");
        model.addAttribute("user",user);
        //model.addAttribute("lastname","Segovia");
        //model.addAttribute("birthdate", LocalDate.parse("2025-05-08"));
        return "details"; //nombre de la vista
    }
    @GetMapping("list")
    public String listUsers(ModelMap model) {
        User user1=new User("Pedro", "Paramo",LocalDate.parse("2025-05-10"));
        User user2=new User("Pedrito", "Paramo",LocalDate.parse("2025-05-10"),"Pedrito@gmial.com");
        User user3=new User("Juan", "Ramirez",LocalDate.parse("2025-05-10"));
        List<User> users = new ArrayList<>(List.of(user1,user2,user3));
        
        model.addAttribute("title","Listado de usuarios");
        model.addAttribute("users", users);
        return null;
    }
    
    
}
