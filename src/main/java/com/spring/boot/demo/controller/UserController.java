package com.spring.boot.demo.controller;

import com.spring.boot.demo.database.UserDataset;
import com.spring.boot.demo.entity.User;
import com.spring.boot.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    private UserDataset dataset;


    @GetMapping("home")
    public String showHelloWorld(){


        return "user";
    }


    @GetMapping("/users/list")
    public String showUserPage(Model model){

        // Get list of user
        List<User> userList =  dataset.getDataset();

        model.addAttribute("userList",userList);


        return "user";
    }




    @RequestMapping("users/delete")
    public String deleteUser(@RequestParam int id){

        // Get list of user
        dataset.deleteUser(id);


        return "redirect:/users/list";
    }










}
