package com.pco.hamrah.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
/*    @RequestMapping("/App")
    public String index1() {
        return "Appppp!";
    }*/

}