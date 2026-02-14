package com.luv2code.demo.rest;

public class StudentNotFoundException extends RuntimeException{

    //when a class extends another class, the child class must call the parent class constructor so that the parent variable can be set..
    //if the parent class does not have constructor, you don't need to use super() or if the child class ain't taking parameters
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
