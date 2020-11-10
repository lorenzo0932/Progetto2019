package com.company;

public class FriendExistException extends Exception {

    public FriendExistException() {
        super();
    }
    
    public FriendExistException(String message) {
        super(message);
    }
}