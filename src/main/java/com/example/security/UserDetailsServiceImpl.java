package com.example.security;

import com.example.models.User;
import com.example.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName();
        if (user == null) {
            throw new UsernameNotFoundException("Username not found" + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), user.getRoles());
    }
}
