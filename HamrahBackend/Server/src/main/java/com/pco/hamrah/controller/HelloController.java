package com.pco.hamrah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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