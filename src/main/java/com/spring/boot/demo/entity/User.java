package com.spring.boot.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    int id;
    String username;
    String password;


    public User(){}

}
