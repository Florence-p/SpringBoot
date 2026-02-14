package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            //  readStudent(studentDAO);

            //  queryForstudent(studentDAO);
            //  queryForstudentByLastName(studentDAO);
            // updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id : primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        student myStudent = studentDAO.findById(studentId);

        //change first name to "scooby"

        System.out.println("updating student....");
        myStudent.setLastName("scooby");
        studentDAO.update(myStudent);
        //update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("updated student: " + myStudent);
    }

    private void queryForstudentByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<student> theStudents = studentDAO.findByLastName("scooby");


        // display list of students
        for (student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForstudent(StudentDAO studentDAO) {
        // get a list of students
        List<student> theStudents = studentDAO.findAll();


        //display list of students
        for (student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }


    private void readStudent(StudentDAO studentDAO) {
        //create a student object
        System.out.println("çreating new student object...");
        student tempStudent = new student("Daffy", "Duck", "daffyduck.com");


        //save the student
        System.out.println("saving the student object...");
        studentDAO.save(tempStudent);


        //display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("saved student. Generated id:  " + theId);

        //retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        student myStudent = studentDAO.findById(theId);
        //display student
        System.out.println(" found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //create multiple students
        System.out.println("creating new student object....");
        student tempStudent1 = new student("John", "Doe", "johnuv2code.com");
        student tempStudent2 = new student("Reb", "bubble", "rebbubble.com");
        student tempStudent3 = new student("Mart", "macha", "martmacha.com");


        // save the student objects
        System.out.println("saving the student.....");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);


    }

    private void createStudent(StudentDAO studentDAO) {

        //Create the student object
        System.out.println("creating new student object....");
        student tempStudent = new student("Paul", "Doe", "paulluv2code.com");

        //save the student object
        System.out.println("saving the student.....");
        studentDAO.save(tempStudent);
        //display id of the saved student
        System.out.println("saved student. Generated id:  " + tempStudent.getId());

    }
}
