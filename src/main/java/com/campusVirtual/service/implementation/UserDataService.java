package com.campusVirtual.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.Userdata;
import com.campusVirtual.repository.UserCredentialsRepository;
import com.campusVirtual.service.IUserDataService;

@Service
public class UserDataService implements IUserDataService {

    @Autowired
    private UserCredentialsRepository userRepository;

    @Override
    public Userdata getUserById(Long document) {
        return this.userRepository.findById(document).get();
    }

    @Override
    public Userdata saveUser(Userdata user) {
        return this.userRepository.save(user);
    }
    
}
