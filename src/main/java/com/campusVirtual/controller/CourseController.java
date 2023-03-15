package com.campusVirtual.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.StudentDto;
import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.service.ICourseService;


@RestController
@RequestMapping(path="v1/cursos")
public class CourseController {
    
    @Autowired
    private ICourseService cursoService;


    @GetMapping(path="/{id}")
    public ResponseEntity<CourseDto> getCursoDtoById(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.cursoService.getCursoDtoById(id));
    }

    @GetMapping(path="/todos")
    public ResponseEntity<List<CourseDto>> getCursoDtoById(){
        return ResponseEntity.ok()
        .body(this.cursoService.getAllCursosDto());
    }

    @GetMapping(path="/{id}/profesores")
    public ResponseEntity<List<ProfessorDto>> getProfesorsById(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.cursoService.getAllProfesoresOfCurso(id));
    }

    @GetMapping(path="/{id}/alumnos")
    public ResponseEntity<List<StudentDto>> getAlumnosById(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.cursoService.getAllAlumnosOfCurso(id));
    }
    
  

    @PostMapping
    public ResponseEntity<CourseDto> crearCursos(@RequestBody CourseDto cursoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.cursoService.saveCursoDto(cursoDto));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable("id") Long id){
        this.cursoService.deleteCursoById(id);
        return ResponseEntity.noContent().build();
    }

}
