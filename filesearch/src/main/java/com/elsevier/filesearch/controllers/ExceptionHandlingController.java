package com.elsevier.filesearch.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.elsevier.filesearch.exception.FileSearchException;

/**
 * This is a controller class to handle exception
 * and update the exception message before sending
 * that back as response to caller
 * @author APD
 *
 */

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(FileSearchException.class)
    //@ResponseStatus(value = 403)
    /**
     * This method will be automatically called by spring framework when there is any kind of 
     * FileSearchException thrown by this application and will generate appropriate exception 
     * reports (FileSearchException) before sending it to the caller
     * @param ex (FileSearchException)
     * @return ResponseEntity
     */
    public ResponseEntity<Object> handleException(FileSearchException ex) {
    	System.out.println("In ExceptionHandlingController - handleException");
        return new ResponseEntity<>(ex.getMessage(), ex.getErrorCode());
    }

}
