package com.example.springboot.thymleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate",java.time.LocalDate.now());
        return "helloworld";
    }
}
