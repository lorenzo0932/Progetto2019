package com.company;

public class DataExistException extends Exception {

    public DataExistException() {
        super();
    }
    
    public DataExistException(String message) {
        super(message);
    }
}
