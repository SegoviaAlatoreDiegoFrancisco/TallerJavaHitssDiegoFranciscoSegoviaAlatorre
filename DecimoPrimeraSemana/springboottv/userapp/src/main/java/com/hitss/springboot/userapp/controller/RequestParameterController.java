package com.hitss.springboot.userapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitss.springboot.userapp.models.ParamDto;


@RestController
@RequestMapping("/api/param")
public class RequestParameterController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required =false, name="mensaje", defaultValue="Hola por defecto") String message) {
        
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    
}
