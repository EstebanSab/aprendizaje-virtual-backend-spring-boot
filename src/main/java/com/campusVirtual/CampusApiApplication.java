package com.campusVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.model.Student;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.Professor;
import com.campusVirtual.security.userPasswordFilter.UserDetailServiceImplementacion;
import com.campusVirtual.service.IAdminService;
import com.campusVirtual.service.implementation.StudentInCourseService;
import com.campusVirtual.service.implementation.StudentService;
import com.campusVirtual.service.implementation.CourseService;
import com.campusVirtual.service.implementation.ProfessorInCourseService;
import com.campusVirtual.service.implementation.ProfessorService;


@SpringBootApplication
public class CampusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusApiApplication.class, args);
	}

	@Bean
    CommandLineRunner commandLineRunner(
            ProfessorService profesorService,
			CourseService cursoService,
			StudentService alumnoService,
			ProfessorInCourseService profesorEnCursoService,
			StudentInCourseService alumnoEnCursoService,
			PasswordEncoder passwordEncoder,
			UserDetailServiceImplementacion udsi,
			IAdminService ias){
	return args -> {
	Professor proIngles=profesorService.saveProfesorNoDto(new Professor("matias","ingles"));
	Professor proIngles2=profesorService.saveProfesorNoDto(new Professor("matia22s","ingles"));
	profesorService.saveProfesorNoDto(new Professor("pablo","matematica"));
	Professor proRedes=profesorService.saveProfesorNoDto(new Professor("Juan","redes"));
	
	
	Course redes=cursoService.saveCursoNoDto(new Course("redes"));
	Course ingles=cursoService.saveCursoNoDto(new Course("ingles"));
	Course ingles2=cursoService.saveCursoNoDto(new Course("ingles avanzado"));
	Course ingles3=cursoService.saveCursoNoDto(new Course("ingles medio"));
	
	

	profesorEnCursoService.asignarProfesorCurso(proRedes.getId(), redes.getId());
	profesorEnCursoService.asignarProfesorCurso(proIngles.getId(), ingles.getId());
	profesorEnCursoService.asignarProfesorCurso(proIngles.getId(), ingles2.getId());
	profesorEnCursoService.asignarProfesorCurso(proIngles.getId(), ingles3.getId());
	profesorEnCursoService.asignarProfesorCurso(proIngles2.getId(), ingles3.getId());
	
	System.out.println(profesorService.getProfesorNoDtoById(proIngles.getId()).getProfesorEnCurso());	

	Student alumno1 =alumnoService.saveAlumnoNoDto(new Student("Pablo"));
	Student alumno2 =alumnoService.saveAlumnoNoDto(new Student("juan"));

	Student alumno3 =alumnoService.saveAlumnoNoDto(new Student("ro"));
	Student alumno4 =alumnoService.saveAlumnoNoDto(new Student("tiago"));

	alumnoEnCursoService.asignarAlumnoCurso(alumno1.getId(),ingles.getId());
	alumnoEnCursoService.asignarAlumnoCurso(alumno2.getId(),ingles.getId());
	alumnoEnCursoService.asignarAlumnoCurso(alumno2.getId(),redes.getId());
	alumnoEnCursoService.asignarAlumnoCurso(alumno3.getId(),redes.getId());
	alumnoEnCursoService.asignarAlumnoCurso(alumno4.getId(),redes.getId());

	
	udsi.saveUser(new UserRegisterDto((long)1,"1", "admin", "admin"));
	ias.asignarRoleUser("ROLE_ADMIN",(long)1);
		};
	
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
    		return new WebMvcConfigurer() {
        		@Override
        		public void addCorsMappings(CorsRegistry registry) {
            		registry.addMapping("/**")
                	.allowedOrigins("http://localhost:4200/login")
					.allowedOrigins("http://localhost:4200")
					.allowedOrigins("*")
					.allowedHeaders("*");
        		}
  		  };
	}
	
	

}
