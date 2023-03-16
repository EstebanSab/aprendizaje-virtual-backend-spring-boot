package com.campusVirtual.service;


import com.campusVirtual.model.Userdata;


public interface IUserDataService {
    public Userdata getUserById(Long document);

    public Userdata saveUser(Userdata user);
}
