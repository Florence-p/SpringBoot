package com.luv2code.ThymeleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // create a mapping for "/hello"
    @GetMapping("/")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());
//Model theModel demonstrates dependency injection
        //Model is simply a container.
        //Think of it like a bag or box that carries data from your
        // controller → to your HTML page.

        //This Line:
        //theModel.addAttribute("theDate", java.time.LocalDateTime.now());
        //Means: “Put something inside the bag.”
        //You're putting: //Key → "theDate" //Value → current date and time
        return "helloworld";
    }

}
