package com.campusVirtual.service;

import com.campusVirtual.model.UserCredentials;

public interface IUserCredentialsService {
    public UserCredentials getUserById(Long document);

    public UserCredentials saveUser(UserCredentials user);

    
}
