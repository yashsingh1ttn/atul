package com.bootcamp.assignment.restfulwebservices.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee retreiveEmployee(@PathVariable int id){
        Employee employee = service.findOne(id);
        if(employee == null)
            throw new UserNotFountException("id : "+ id);
        return employee;
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee){
        Employee savedEmployee = service.save(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee employee = service.deleteById(id);
        if(employee == null)
            throw new UserNotFountException("id : "+ id);
    }

//    @PutMapping("/edit")
//    public String updateEmployee(Employee employee){
//        return service.editEmployeeDetails(employee);
//    }
}
