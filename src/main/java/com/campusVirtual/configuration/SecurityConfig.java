package com.campusVirtual.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.campusVirtual.security.jwtFilter.JwtRequestFilter;
import com.campusVirtual.security.userPasswordFilter.UserPasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    

    private final UserDetailsService miUserDetailsService;
    private PasswordEncoder passwordeEncoder;
   
    @Autowired
    public SecurityConfig( 
        UserDetailsService miUserDetailsService,
        PasswordEncoder passwordeEncoder){
            this.miUserDetailsService=miUserDetailsService;
            this.passwordeEncoder=passwordeEncoder;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http,AuthenticationManager authManager){
       UserPasswordAuthenticationFilter userPasswordAuthenticationFilter = new UserPasswordAuthenticationFilter();
       userPasswordAuthenticationFilter.setAuthenticationManager(authManager);
       userPasswordAuthenticationFilter.setFilterProcessesUrl(
        "/v1/login");
        
        try {
            return http
                        .csrf().disable()
                        .authorizeRequests()
                        //.antMatchers(HttpMethod.POST, "/v1/login").permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .addFilter(userPasswordAuthenticationFilter)
                        .addFilterBefore(new JwtRequestFilter(), UsernamePasswordAuthenticationFilter.class)
                        .build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean 
    AuthenticationManager authManager(HttpSecurity http)throws Exception{
        return http
            .getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(miUserDetailsService)
            .passwordEncoder(passwordeEncoder)
            .and()
            .build();

    }

   
}
