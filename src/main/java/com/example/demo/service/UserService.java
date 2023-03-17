package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByEmailAndPassword(LoginRequest loginRequest)
    {
        return userRepository.findUserByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
    }

    public User findUserByEmail(String email)
    {
        return userRepository.findUserByEmail(email);
    }

    public User save(User user)
    {
        return userRepository.save(user);
    }
}
