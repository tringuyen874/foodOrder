package com.example.foodOrder.controllers;

import com.example.foodOrder.models.User;
import com.example.foodOrder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userapi")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{username}")
    public User findByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

}
