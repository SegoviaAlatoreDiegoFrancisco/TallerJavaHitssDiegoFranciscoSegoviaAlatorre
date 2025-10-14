package com.hitss.springboot.userapp.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController //->JSON @Controller y @ResponseBody
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
    
}
