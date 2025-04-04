package com.example.springboot.thymleafdemo.controller;

import com.example.springboot.thymleafdemo.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${opsystems}")
    private List<String> favops;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("languages", languages);
        theModel.addAttribute("favops", favops);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@Valid @ModelAttribute("student") Student theStudent, BindingResult bindingResult, Model theModel){

        if (bindingResult.hasErrors()) {
            theModel.addAttribute("student", theStudent);
            theModel.addAttribute("countries", countries);
            theModel.addAttribute("languages", languages);
            theModel.addAttribute("favops", favops);

            System.out.println("Binding result: " + bindingResult.toString());
            System.out.println("\n\n\n\n");
            return "student-form"; // back to form if errors
        }

        return "student-confirmation";

    }
}
