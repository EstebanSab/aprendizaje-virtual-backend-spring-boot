package com.campusVirtual.security.userPasswordFilter;

import java.util.Collections;
import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.campusVirtual.model.Userdata;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserDetailsImplementacion implements UserDetails {

    private final Userdata userAuth;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Collections.emptyList();
    }

  

    @Override
    public String getPassword() {
        //return "$2a$10$rPulPOsOyLYSu3dl2BHUJuG1yUyWU1UXmkSyanaiecfus.vqOE8qS";//1
        return userAuth.getPassword();
    }

    @Override
    public String getUsername() {
       return ""+userAuth.getDocument();
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    public String getStringAuthorities() {
        return this.userAuth.getAuthorities();
    }
    
}
