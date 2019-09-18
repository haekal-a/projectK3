package com.example.demo.service;

import com.example.demo.domain.dbpenaridesa.UserEntity;
import com.example.demo.repo.dbpenaridesa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser (UserEntity user){
        return userRepository.save(user);
    }
}
