package com.company;

public class CategoryNotExistException extends Exception {

    public CategoryNotExistException() {
        super();
    }
    
    public CategoryNotExistException(String message) {
        super(message);
    }
}