package com.campusVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.model.Alumno;
import com.campusVirtual.model.Curso;
import com.campusVirtual.model.Profesor;
import com.campusVirtual.security.userPasswordFilter.UserDetailServiceImplementacion;
import com.campusVirtual.service.IAdminService;
import com.campusVirtual.service.implementation.AlumnoEnCursoService;
import com.campusVirtual.service.implementation.AlumnoService;
import com.campusVirtual.service.implementation.CursoService;
import com.campusVirtual.service.implementation.ProfesorEnCursoService;
import com.campusVirtual.service.implementation.ProfesorService;


@SpringBootApplication
public class EmpleadosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleadosApiApplication.class, args);
	}

	@Bean
    CommandLineRunner commandLineRunner(
            ProfesorService profesorService,
			CursoService cursoService,
			AlumnoService alumnoService,
			ProfesorEnCursoService profesorEnCursoService,
			AlumnoEnCursoService alumnoEnCursoService,
			PasswordEncoder passwordEncoder,
			UserDetailServiceImplementacion udsi,
			IAdminService ias){
	return args -> {
	Profesor proIngles=profesorService.saveProfesorNoDto(new Profesor("matias","ingles"));
	Profesor proIngles2=profesorService.saveProfesorNoDto(new Profesor("matia22s","ingles"));
	profesorService.saveProfesorNoDto(new Profesor("pablo","matematica"));
	Profesor proRedes=profesorService.saveProfesorNoDto(new Profesor("Juan","redes"));
	
	
	Curso redes=cursoService.saveCursoNoDto(new Curso("redes"));
	Curso ingles=cursoService.saveCursoNoDto(new Curso("ingles"));
	Curso ingles2=cursoService.saveCursoNoDto(new Curso("ingles avanzado"));
	Curso ingles3=cursoService.saveCursoNoDto(new Curso("ingles medio"));
	
	

	profesorEnCursoService.asignarProfesorCurso(proRedes.getId(), redes.getId());
	profesorEnCursoService.asignarProfesorCurso(proIngles.getId(), ingles.getId());
	profesorEnCursoService.asignarProfesorCurso(proIngles.getId(), ingles2.getId());
	profesorEnCursoService.asignarProfesorCurso(proIngles.getId(), ingles3.getId());
	profesorEnCursoService.asignarProfesorCurso(proIngles2.getId(), ingles3.getId());
	
	System.out.println(profesorService.getProfesorNoDtoById(proIngles.getId()).getProfesorEnCurso());	

	Alumno alumno1 =alumnoService.saveAlumnoNoDto(new Alumno("Pablo"));
	Alumno alumno2 =alumnoService.saveAlumnoNoDto(new Alumno("juan"));

	Alumno alumno3 =alumnoService.saveAlumnoNoDto(new Alumno("ro"));
	Alumno alumno4 =alumnoService.saveAlumnoNoDto(new Alumno("tiago"));

	alumnoEnCursoService.asignarAlumnoCurso(alumno1.getId(),ingles.getId());
	alumnoEnCursoService.asignarAlumnoCurso(alumno2.getId(),ingles.getId());
	alumnoEnCursoService.asignarAlumnoCurso(alumno2.getId(),redes.getId());
	alumnoEnCursoService.asignarAlumnoCurso(alumno3.getId(),redes.getId());
	alumnoEnCursoService.asignarAlumnoCurso(alumno4.getId(),redes.getId());

	
	udsi.saveUser(new UserRegisterDto((long)1,"1", "admin", "admin"));
	ias.asignarRoleUser("ROLE_ADMIN",(long)1);
		};
	
	}

}
