package com.example.services;

import com.example.models.User;
import com.example.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }
}
