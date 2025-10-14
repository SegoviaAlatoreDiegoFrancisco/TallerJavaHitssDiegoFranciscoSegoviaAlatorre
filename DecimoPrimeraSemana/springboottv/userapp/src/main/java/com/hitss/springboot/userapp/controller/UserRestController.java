package com.hitss.springboot.userapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitss.springboot.userapp.models.User;
import com.hitss.springboot.userapp.models.UserDTO;



@RestController //->JSON @Controller y @ResponseBody
@RequestMapping("/api/user")
public class UserRestController {
    @GetMapping("/detailsapirest")
   
    public Map<String,Object> details() {
        Map<String, Object> body = new HashMap<>();
        body.put("title","Hola Mundo SpringBoot 3");
        body.put("name","Francisco");
        body.put("lastname","Segovia");
        body.put("birthdate",LocalDate.parse("1999-05-08"));
        return body;    
    }
    
    @GetMapping("details-map")
    public Map<String,Object> detailsUser() {
        User user = new User("Diego", "Segovia", LocalDate.parse("1999-08-05"));
        Map<String, Object> body = new HashMap<>();
        body.put("title", "UserSprnigBoot");
        body.put("user",user);
        return body;
    }
    
    @GetMapping("details")
    public UserDTO detailsUserDTO() {
        User user = new User("Diego", "Segovia", LocalDate.parse("1999-08-05"));
        UserDTO userDTO = new UserDTO();
        userDTO.setTitle("UserSprnigBoot");
        userDTO.setUser(user);
        return userDTO;
    }
    @GetMapping("list")
    public List<User> list() {
        User user1 = new User("Diego", "Segovia", LocalDate.parse("1999-08-05"));
        User user2 = new User("Pedro", "Bermudez", LocalDate.parse("1999-08-05"));
        User user3 = new User("Emiliano", "Nunez", LocalDate.parse("1999-08-05"));

        List<User> users = new ArrayList<>(List.of(user1, user2, user3));
        return users;
    }
    
}
