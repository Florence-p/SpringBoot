package com.luv2code.springboot.demo.mycoolapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFunController {

    @GetMapping("/")
    public String SayHello(){
        return "Hello World";
    }
}
