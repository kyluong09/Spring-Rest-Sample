package com.spring.boot.demo;

import com.spring.boot.demo.entity.User;
import com.spring.boot.demo.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDataset {
    List<User> dataset = new ArrayList<>();
    private static  UserDataset INSTANCE = null;

    private UserDataset(){
        loadData();
    }

    private void loadData(){
        dataset.add(new User(1,"user1","password"));
        dataset.add(new User(2,"user2","password"));
        dataset.add(new User(3,"user3","password"));
        dataset.add(new User(4,"user4","password"));
        dataset.add(new User(5,"user5","password"));
        dataset.add(new User(6,"user6","password"));
    }

    public List<User> getDataset() {
        return dataset;
    }


    /**
     * Find user by Id
     * @param id
     * @return
     */
    public Optional<User> getUserById(int id){

        Optional<User> user = dataset.stream().filter(u -> u.getId() == id).findFirst();




        return user;



    }
}
