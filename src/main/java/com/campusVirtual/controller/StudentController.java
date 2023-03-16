package com.campusVirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.model.Student;
import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.service.IStudentService;



@RestController
@RequestMapping(path="v1/alumnos")
public class StudentController {/* 
    
    @Autowired
    private IStudentService studentService;
    
    
    @GetMapping(path="/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  ResponseEntity<Student> getStudenById(@PathVariable("id") Long id){
        return  ResponseEntity.ok()
                .body(this.studentService.getStudentById(id));
    }

    @GetMapping(path="/me")
    @PreAuthorize("hasRole('ROLE_ALUMNO')")
    public  /*ResponseEntity<AlumnoDto>String getAlumnoDtoByContex(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
        //return  ResponseEntity.ok()
        //        .body(this.alumnoService.getAlumnoDtoById(id));
    }



    @GetMapping(path="/todos")
    @PreAuthorize("hasRole('ROLE_ALUMNO')")
    public ResponseEntity<List<StudentDto>> getAllAlumnoDto(){
        return ResponseEntity.ok()
                .body(this.alumnoService.getAllAlumnoDto());
    }

    @GetMapping(path="/{id}/cursos")
    public ResponseEntity<List<CourseDto>> getAllCursosAlumno(@PathVariable("id") Long id){
        return ResponseEntity.ok()
                .body(this.alumnoService.getAllCursosAlumno(id));
    }
    

    @PostMapping(path="")
    public ResponseEntity<StudentDto> nuevoAlumno(@RequestBody StudentDto alumnoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.alumnoService.saveAlumnoDto(alumnoDto));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable("id") Long id){
        this.alumnoService.deleteAlumnoById(id);
        return ResponseEntity.noContent().build();
    }

    */
}
