package com.example.demo.service;

import com.example.demo.domain.dbpenaridesa.UserEntity;
import com.example.demo.model.UserOutputModel;
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

    public UserOutputModel getUser(String username){
        UserOutputModel output = new UserOutputModel();
        UserEntity data = userRepository.findByUsername(username);
        if(data != null){
            output.setUsername(data.getUsername());
            output.setPassword(data.getPassword());
            output.setRole(data.getRole());
        }
        return output;
    }
}
