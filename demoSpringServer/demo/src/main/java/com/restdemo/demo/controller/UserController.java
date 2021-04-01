package com.restdemo.demo.controller;

import com.restdemo.demo.database.DatabaseHandler;
import com.restdemo.demo.main.User;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("user")
public class UserController {
    DatabaseHandler databaseHandler=new DatabaseHandler();
    private User user=new User("ilya","gorbach",new Date(1000,2,2),"stayh","+79295");
    @GetMapping
    public User currentUser(){
        return user;
    }

    @PostMapping
    public void registerUser(@RequestBody User user){
        databaseHandler.signUpUser(user);
    }
}
