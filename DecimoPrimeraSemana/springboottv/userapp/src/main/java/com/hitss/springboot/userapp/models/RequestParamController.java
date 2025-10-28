package com.hitss.springboot.userapp.models;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitss.springboot.userapp.models.dto.ParamDto;
import com.hitss.springboot.userapp.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/param")
public class RequestParamController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required=false , defaultValue="Mensaje por defecto", name="mensaje") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDto param = new ParamMixDto();
        param.setMessage(text);
        param.setCode(code);
        return param;
    }
    @GetMapping("/request")
    public ParamMixDto request( HttpServletRequest request) {
        ParamMixDto param = new ParamMixDto();
        Integer code = 0;
        try {
            code = Integer.valueOf(request.getParameter("code"));
        } catch (NumberFormatException e) {
            System.out.print("Error: no se puede parsear...");
        }
        param.setMessage(request.getParameter("message"));
        param.setCode(code);
        return param;
    }
    
    
}
