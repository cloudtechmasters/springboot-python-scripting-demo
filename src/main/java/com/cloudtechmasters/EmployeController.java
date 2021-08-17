package com.cloudtechmasters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class EmployeController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(EmployeController.class);
    @Autowired
    EmployeeRepository employeeRepository;
    //create a employee
    @PostMapping("/createEmployee")
    public  String createNewCustomer(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return "employee created";
    }

    //list all employee
    @GetMapping("/listAllEmployees")
    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = new LinkedList<>();

        Iterable<Employee> iterable = employeeRepository.findAll();
        iterable.forEach(employeeList::add);

        return employeeList;
    }

    //find employee details by employee Name
    @GetMapping("/getEmployeeByName")
    public Employee getEmployeeByName(@RequestParam String empName){
        return (Employee) jdbcTemplate.query(
                "select * from employee where emp_name='krishnavamsi'",new EmployeeRowMapper()).get(0);

    }

}
