package com.stackroute.exceptions;

public class TrackNotFoundExceptions extends Exception{

    private String message;
    public TrackNotFoundExceptions(String message)
    {
        super(message);
        this.message=message;
    }

}
