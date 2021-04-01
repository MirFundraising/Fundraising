package com.restdemo.mirSpringServer.controller;

import com.restdemo.mirSpringServer.database.DatabaseHandler;
import com.restdemo.mirSpringServer.main.User;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("user")
public class UserController {
    DatabaseHandler databaseHandler=new DatabaseHandler();
    private User user=new User("ilya","gorbach",new Date(100,7,31),"stayhigh78@mail.ru","+79295868735");
    @GetMapping
    public User currentUser(){
        return user;
    }

    @PostMapping
    public void registerUser(@RequestBody User user){
        databaseHandler.signUpUser(user);
    }
}