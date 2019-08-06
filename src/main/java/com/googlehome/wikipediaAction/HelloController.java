package com.googlehome.wikipediaAction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

    @RequestMapping("/hello")
    public String getHello(){
        System.out.println("HELLLOO");
        return "helloooo";
    }
}