package com.example.explorecalijpa.exceptions;

import java.util.NoSuchElementException;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request){
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        return createResponseEntity(pd, null, HttpStatus.NOT_FOUND, request);
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<Object> handleNoSuchElementException(Exception ex, WebRequest request){
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return createResponseEntity(pd, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
