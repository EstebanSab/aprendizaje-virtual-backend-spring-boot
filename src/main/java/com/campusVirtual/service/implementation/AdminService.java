package com.campusVirtual.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.service.IAdminService;
import com.campusVirtual.service.IUserDataService;

@Service
public class AdminService implements IAdminService{

    @Autowired
    private IUserDataService userDataService;

    @Override
    public void setRoleUser(String role, Long id) {
        this.userDataService.getUserById(id).addAuthorities(role);
    }
}