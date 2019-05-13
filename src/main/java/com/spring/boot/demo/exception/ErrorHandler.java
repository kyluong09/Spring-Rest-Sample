package com.spring.boot.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {


    /**
     * Not Found Exception Handler
     * @param exception
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<ErrorObj> NotFoundHandler(NotFoundException exception){
        // Create & Set ErrorObj
        ErrorObj error = new ErrorObj(HttpStatus.NOT_FOUND.value(),exception.getMessage(),System.currentTimeMillis());



        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    /**
     * Bad Request Exception Handler
     * @param exception
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<ErrorObj> BadRequestHandler(Exception exception){
        // Create & Set ErrorObj
        ErrorObj error = new ErrorObj(HttpStatus.BAD_REQUEST.value(),exception.getMessage(),System.currentTimeMillis());



        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
