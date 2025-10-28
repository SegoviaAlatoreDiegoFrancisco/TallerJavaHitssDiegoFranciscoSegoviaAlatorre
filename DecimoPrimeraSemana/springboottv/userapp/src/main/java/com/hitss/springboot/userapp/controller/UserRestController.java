package com.hitss.springboot.userapp.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hitss.springboot.userapp.models.User;
import com.hitss.springboot.userapp.models.dto.UserDto;



@RestController //->JSON //conjunta @Controller @ResponseBody
@RequestMapping("/api/user") //a nivel de clase nos da una URL base
public class UserRestController {

    //@GetMapping("detailsapi")
    @RequestMapping(path= "/details-map",method=RequestMethod.GET)
    public Map<String,Object> details() {
        Map<String,Object> body = new HashMap<>();
        body.put("title","HolaMundo Spring Boot API Map");
        body.put("name","Diego");
        body.put("lastname","Segovia");
        body.put("birthdate",LocalDate.parse("1999-05-08"));
        return body;
    }
    @GetMapping("details-user")
    public Map<String, Object> detailsUser( ) {
        Map<String, Object> body = new HashMap<>();
        User user = new User("Francisco", "Segovia",LocalDate.parse("2025-05-08"));
        body.put("title", "User Spring Boot");
        body.put("user", user);
        return body;
    }
    @GetMapping("details")
    public UserDto detailsUserDto( ) {
        User user = new User("Francisco", "Segovia",LocalDate.parse("2025-05-08"));
        UserDto userDto = new UserDto();
        userDto.setTitle("User Dto SpringBoot");
        userDto.setUser(user);
        

        return userDto;
    }
    @GetMapping("list")
    public List<User> list() {
        User user1= new User("Pedro", "Paramo") ;
        User user2= new User("Pedrito", "Paramito") ;
        User user3= new User("Lupe", "Esparza") ;
        List<User> users = List.of(user1, user2, user3); //arrays.asList
        return users;
    }
        
}
