package com.example.springboot.thymleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }


    @RequestMapping("/processForm")
    public String processForm(){
        return "hellostudent";
    }

    @PostMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "HELLO " + theName;

        model.addAttribute("message", result);

        return "hellostudent";
    }


    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();

        String result = "HELLO " + theName;

        model.addAttribute("message", result);

        return "hellostudent";
    }


}
