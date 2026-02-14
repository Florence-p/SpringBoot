package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.student;

import java.util.List;

public interface StudentDAO {

    void save (student theStudent);

    student findById (Integer id);

    List<student> findAll();

List<student> findByLastName (String theLastName);

void update (student theStudent);
}
