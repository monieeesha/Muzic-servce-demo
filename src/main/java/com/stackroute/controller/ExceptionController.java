package com.stackroute.controller;

import com.stackroute.exceptions.TrackAlreadyExistsExceptions;
import com.stackroute.exceptions.TrackNotFoundExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value= TrackAlreadyExistsExceptions.class)
    public ResponseEntity<String> exception(TrackAlreadyExistsExceptions exception)
    {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value= TrackNotFoundExceptions.class)
    public ResponseEntity<String> exception1(TrackNotFoundExceptions exception1)
    {
        return new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
    }
}