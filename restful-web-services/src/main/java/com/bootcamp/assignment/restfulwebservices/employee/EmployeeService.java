package com.bootcamp.assignment.restfulwebservices.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Spliterators.iterator;

@Component
public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();

    private static int employeeCount=4;

    //Adding employee in the static list
    static{
        employees.add(new Employee(1, "Yash Vardhan Singh", 22));
        employees.add(new Employee(2, "Abhishek Jaiswal", 21));
        employees.add(new Employee(3, "Himanshu Singh", 24));
        employees.add(new Employee(4, "Atul Singh", 22));
    }

    //Get all employee details presnet
    public List<Employee> findAll(){
        return employees;
    }

    //for adding employee to employees list
    public Employee save(Employee employee){
        if(employee.getId() == 0) {
            employee.setId(++employeeCount);
        }
        employees.add(employee);
        return employee;
    }

    public Employee findOne(int id){
         for(Employee employee : employees){
             if(employee.getId() == id){
                 return employee;
             }
         }
         return null;
    }

    public Employee deleteById(int id){
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee.getId() == id) {
                iterator.remove();
                return employee;
            }
            
        }
        return null;
    }

//    public String editEmployeeDetails(Employee employee){
//        employees.stream()
//                .filter(e-> e.getId() == employee.getId())
//                .forEach(e -> {
//                    e.setName(employee.getName());
//                    e.setAge(employee.getAge());
//                });
//                    return "Sucessfully Updated";
//    }



}
