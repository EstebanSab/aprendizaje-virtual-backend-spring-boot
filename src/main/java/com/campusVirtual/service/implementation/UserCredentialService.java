package com.campusVirtual.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.campusVirtual.model.UserCredentials;
import com.campusVirtual.repository.UserCredentialsRepository;
import com.campusVirtual.service.IUserCredentialsService;

public class UserCredentialService implements IUserCredentialsService {

    @Autowired
    private UserCredentialsRepository userRepository;

    @Override
    public UserCredentials getUserNoDtoById(Long document) {
        return this.userRepository.findById(document).get();
    }
    
}
