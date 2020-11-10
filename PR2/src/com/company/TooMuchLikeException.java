package com.company;

public class TooMuchLikeException extends Exception {

    public TooMuchLikeException() {
        super();
    }
    
    public TooMuchLikeException(String message) {
        super(message);
    }
}