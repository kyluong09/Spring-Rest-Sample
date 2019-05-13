package com.spring.boot.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotFoundObject {

    private int code;
    private String message;
    private String time;
}
