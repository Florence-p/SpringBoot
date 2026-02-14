package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @PostConstruct to load the student data --only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Ade", "Patel"));
        theStudents.add(new Student("Queen", "Vee"));
        theStudents.add(new Student("Ash", "Ley"));
    }
    //define an endpoint for "/student" --return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {


        return theStudents;
    }

    //define endpoint or "/students/{studentId}" -return student by Index of the arraylist
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //just index into the list....keep it simple for now

        // check the studentId againts list size with an if statement

        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("student id not found- " + studentId);
        }
        return theStudents.get(studentId);
    }




}
