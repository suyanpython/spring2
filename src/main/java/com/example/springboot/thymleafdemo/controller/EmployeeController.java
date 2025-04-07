package com.example.springboot.thymleafdemo.controller;

import com.example.springboot.thymleafdemo.dao.EmployeeRepository;
import com.example.springboot.thymleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeRepository employeeRepository ;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/list")
    public String ListEmployees(Model theModel){
        //List<Employee> theEmployees = employeeRepository.findAll();
        List<Employee> theEmployees = employeeRepository.findAllByOrderByLastNameAsc();
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        //Optional<Employee> theEmployee = employeeRepository.findById(theId);
        Employee theEmployee = employeeRepository.findById(theId)
                .orElseThrow(() -> new RuntimeException("Employee not found - " + theId));

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId, Model theModel){
        employeeRepository.deleteById(theId);
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeRepository.save(theEmployee);

        return "redirect:/employees/list";
    }
}
