package com.company;


public class CategoryExistenceException extends Exception {

    public CategoryExistenceException() {
        super();
    }
    
    public CategoryExistenceException(String message) {
        super(message);
    }
}
