package com.spring.boot.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorObj {
    private int status;
    private String message;
    private long timeStamp;

    public ErrorObj(){}
}
