package com.luv2code.springboot.cruddemo.Controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
//    Since only one constructor @Autowired is optional
    public EmployeeController(EmployeeService theEmployeeService){
        this.employeeService = theEmployeeService;
    }

//    add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model){
        // get the employees from db
        List<Employee> employees = employeeService.findAll();
//        add to the spring model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping ("/save")
    public String showFormForAdd(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
