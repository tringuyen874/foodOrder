package com.example.foodOrder.services;

import com.example.foodOrder.models.Role;
import com.example.foodOrder.models.User;
import com.example.foodOrder.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> userRoles = new HashSet<>();

        Role userRole = new Role();
        userRole.setName("USER");
        userRole.setId(2L);
//        Role adminRole = new Role();
//        adminRole.setName("ADMIN");
//        adminRole.setId(1L);

        userRoles.add(userRole);
//        userRoles.add(adminRole);
        user.setRoles(userRoles);
        return userRepo.save(user);
    }

    public User findUserByUsername(String username) {

        return userRepo.findByUserName(username);
    }
}
