package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //this method simply returns all the employees
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    Void deleteById(int theId);


}
