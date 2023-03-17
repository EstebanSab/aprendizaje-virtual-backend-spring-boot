package com.campusVirtual.security.userPasswordFilter;


import com.campusVirtual.security.jwtFilter.*;
import com.campusVirtual.dto.UserCredentialsDto;


import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private JwtUtils tokenJwtUtil = new JwtUtils();

    @Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
	

        UserCredentialsDto AuthCredentialsDto = new UserCredentialsDto();
        try{
            
            AuthCredentialsDto = new ObjectMapper().readValue(request.getReader(),UserCredentialsDto.class);
        
        
        }catch(IOException e){
            System.out.println("No se pueden validad las credenciales");
        }
        

        UsernamePasswordAuthenticationToken userPAT= new UsernamePasswordAuthenticationToken(
            AuthCredentialsDto.getDocumentoString(),  AuthCredentialsDto.getPassword(),
            Collections.emptyList()/*roles*/);
		
        return getAuthenticationManager().authenticate(userPAT);
	}

    @Override
    protected void successfulAuthentication(
        HttpServletRequest request, 
        HttpServletResponse response, 
        FilterChain chain,
		Authentication authResult) throws IOException, ServletException {
        
        UserDetailsImplementacion userImp= (UserDetailsImplementacion)authResult.getPrincipal();
        
        String token = tokenJwtUtil.createToken(userImp.getUsername(),userImp.getStringAuthorities());
	
	//response.addHeader("Access-Control-Allow-Origin", "*,*");	

	response.addHeader("Access-Control-Expose-Headers","Authorization");	
	response.addHeader("Access-Control-Allow-Headers","Authorization,X-PINGOTHER,Origin,X-Requested-with,Contenr-type,Accept,X-Custom-header");
        response.addHeader("Authorization", "Bearer "+token);

        response.getWriter().flush();
        
        
        super.successfulAuthentication(request, response, chain, authResult);
        //chain.doFilter(request, response);
    }
}
