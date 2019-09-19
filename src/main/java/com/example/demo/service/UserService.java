package com.example.demo.service;

import com.example.demo.domain.dbpenaridesa.UserEntity;
import com.example.demo.model.UserOutputModel;
import com.example.demo.repo.dbpenaridesa.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private IUserRepo userRepo;

    @Autowired
    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity saveUser (UserEntity user){
        return userRepo.save(user);
    }

    public UserOutputModel getUser(String username){
        UserOutputModel output = new UserOutputModel();
        UserEntity data = userRepo.findByUsername(username);
        if(data != null){
            output.setUsername(data.getUsername());
            output.setPassword(data.getPassword());
            output.setRole(data.getRole());
        }
        return output;
    }
}
