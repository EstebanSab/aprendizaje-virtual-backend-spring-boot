package com.campusVirtual.security.userPasswordFilter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.Userdata;
import com.campusVirtual.repository.UserCredentialsRepository;
import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.exception.UserNotFoundException;

@Service
public class UserDetailServiceImplementacion implements UserDetailsService{

    @Autowired
    private UserCredentialsRepository authCredentialsRepository;

    @Autowired
	PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String dniString) throws UsernameNotFoundException { 
        Long dni = Long.parseLong(dniString); 
        Userdata  UserAuth = this.authCredentialsRepository.findById(dni).orElseThrow(()-> new UserNotFoundException(dni));
        //AuthCredentials  UserAuth = new AuthCredentials(dni, "juan","a");
        return new UserDetailsImplementacion(UserAuth);
    }


    public String saveUser(UserRegisterDto userCredentials){
        
        Long documento = userCredentials.getDocumento();
		String password = userCredentials.getPassword();

		
		 if (password == null)
			throw new RuntimeException("the password was not entered");
        else if (documento == null)
			throw new RuntimeException("the dni was not entered");
		
        
        if ((""+documento).isBlank() || password.isBlank())
			throw new RuntimeException("Documento o password no puede estar vacio");

        if (this.authCredentialsRepository.existsById(documento))
			throw new RuntimeException("Usuario con ese documento ya existe");
		
	
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
		
		this.authCredentialsRepository.save(new Userdata(userCredentials.getDocumento(),
        userCredentials.getPassword(),
        userCredentials.getNombre(),userCredentials.getApellido(),userCredentials.getMail()));
		
		
		return  " your registration was successful!";
		
		}
	
    
}
