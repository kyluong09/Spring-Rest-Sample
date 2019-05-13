package com.spring.boot.demo.rest;


import com.spring.boot.demo.database.UserDataset;
import com.spring.boot.demo.entity.User;
import com.spring.boot.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRepository {

    @Autowired
    private UserDataset dataset;



    /**
     * Find All User
     */
    @GetMapping("/users")
    public List<User> findAll(){

        // Return dataset as json format
        return dataset.getDataset();

    }

    /**
     * Find User By Id
     * @return
     */
    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id) throws Exception {

        Optional<User> user = dataset.getUserById(id);

        if(!user.isPresent()){
            throw new NotFoundException("User id is not found: "+ id);
        }

        return user.get();

    }

    /**
     * Create a new user
     */
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
         // user.id is empty or null means 0
        // If we have real database, it would check if user.id is null or 0 then generate unique id for us
        // but we dont have it, so we need to set it manually
        user.setId(dataset.getDataset().size() + 1);

        // Save User to 'fake' database
        dataset.getDataset().add(user);

        // Then return user with generated id
        return user;

    }


    /**
     * Update an user
     */
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) throws Exception{
        // Check if user.id exists
        Optional<User> tempUser = dataset.getDataset().stream().filter(u -> u.getId() == user.getId()).findFirst();
        // Check if user exists then save
        if(tempUser.isPresent()){
            tempUser.get().setUsername(user.getUsername());
            tempUser.get().setPassword(user.getPassword());
        }
        else{
            throw new NotFoundException("User id is not found: "+ user.getId());
        }

        return tempUser.get();

    }

    /**
     * Delete user with id
     */
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id){
        // Check if user exists
        // Otherwise throw exception
        Optional<User> tempUser = dataset.getDataset().stream().filter(u -> u.getId() == id).findFirst();
        if(tempUser.isPresent()){
            // Delete
            dataset.getDataset().remove(tempUser.get());
        }else{
            throw new NotFoundException("User id is not found: "+ id);
        }

        return tempUser.get();
    }


}
