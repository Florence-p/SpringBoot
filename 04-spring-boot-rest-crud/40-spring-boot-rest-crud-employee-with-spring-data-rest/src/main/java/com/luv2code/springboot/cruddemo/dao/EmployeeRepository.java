package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members")---> here is to change the path
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
    //Integer because our employee entity class is based on an Integer primary key
    // Employee is the entity type
    //that's it, no need to write any code
}
