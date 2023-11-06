package com.example.checkpoint.checkpoint2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/checkpoint")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addEmployee(@RequestParam String fullname, @RequestParam String employementDate) {
        Employee newEmployee = new Employee();

        newEmployee.setFullname(fullname);
        newEmployee.setEmployementDate(employementDate);
        employeeRepository.save(newEmployee);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/getById")
    public @ResponseBody Employee getEmployeeById(@RequestParam String id) {
        return employeeRepository.findById(id).get();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteEmployee(@RequestParam String id) {
        employeeRepository.deleteById(id);

        return "Removed";
    }

    @PutMapping(path = "/change")
    public @ResponseBody Employee modifyEmployee(@RequestParam String id, @RequestParam String fullname, @RequestParam String employementDate) {
        Employee employeeModify = employeeRepository.findById(id).get();

        employeeModify.setFullname(fullname);
        employeeModify.setEmployementDate(employementDate);
        employeeRepository.save(employeeModify);

        return employeeModify;
    }
}
