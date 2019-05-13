package com.spring.boot.demo.exception;

public class NotFoundException extends RuntimeException {


    public NotFoundException(String message) {
        super(message);
    }


}

