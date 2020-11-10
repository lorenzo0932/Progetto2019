package com.company;

public class FriendNotExistException extends Exception {

    public FriendNotExistException() {
        super();
    }
    
    public FriendNotExistException(String message) {
        super(message);
    }
}