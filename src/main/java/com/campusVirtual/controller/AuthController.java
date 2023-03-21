package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.dto.UserCredentialsDto;
import com.campusVirtual.security.userPasswordFilter.UserDetailServiceImplementacion;



@RestController
@RequestMapping("v1/auth")
public class AuthController {

    @Autowired
    UserDetailServiceImplementacion userDetailServiceImplementacion;
    
    @PostMapping(path ="/login")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String register(@RequestBody UserCredentialsDto urdto){
       return "login";
    }

    @PostMapping(path ="/register")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String register(@RequestBody UserRegisterDto urdto){
        return userDetailServiceImplementacion.saveUser(urdto);
    }
}