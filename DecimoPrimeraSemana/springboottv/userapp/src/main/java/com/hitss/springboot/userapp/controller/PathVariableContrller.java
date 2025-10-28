package com.hitss.springboot.userapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitss.springboot.userapp.models.User;
import com.hitss.springboot.userapp.models.dto.ParamDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/var")
public class PathVariableContrller {
    @RequestMapping("(/baz/{message})")
    public ParamDto baz(@PathVariable(name="message") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    @GetMapping("/mix/{name}/{id}")
    public Map<String,Object> mixVariables(@PathVariable String name,
                                            @PathVariable long id) {
        Map<String,Object>  json = new HashMap<>();
        json.put("message", name);
        json.put("id", id);
        
        return json;
    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        //Hacer algo con el usuario -> cargarlo a una base de datos
        user.setName(user.getName().toUpperCase());
        user.setLastname(user.getLastname().toUpperCase());
        return user;
    }
    
    
}
