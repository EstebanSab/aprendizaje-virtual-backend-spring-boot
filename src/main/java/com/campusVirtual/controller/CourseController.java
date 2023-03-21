package com.campusVirtual.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.CourseContentDto;
import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.service.ICourseService;



@RestController
@RequestMapping(path="v1/course")
public class CourseController {
    
    @Autowired
    private ICourseService courseService;


    @GetMapping(path="/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CourseDto> getCourseDtoById(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.courseService.getCourseDtoById(id));
    }

    @GetMapping(path="/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CourseDto>> getAllCourseDtoById(){
        return ResponseEntity.ok()
        .body(this.courseService.getAllCoursesDtos());
    }



    @GetMapping(path="/student/courses")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<List<CourseDto>> getAllCoursesOfStudent(){
        
        Long idStudent = Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
        
        return ResponseEntity.ok()
        .body(this.courseService.getAllCoursesOfStudent(idStudent));
    }


    @GetMapping(path="/professor/courses")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public ResponseEntity<List<CourseDto>> getAllCoursesOfProfessor(){

        Long idProfessor = Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
        
        return ResponseEntity.ok()
        .body(this.courseService.getAllCoursesOfProfessor(idProfessor));
    }

   
    
  

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto cursoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.courseService.saveCourseDto(cursoDto));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable("id") Long id){
        this.courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }



    @PostMapping("/{id}/content")
    public ResponseEntity<?> addCourseContent(@PathVariable("id") Long id,@RequestBody CourseContentDto ccDto){
        this.courseService.addCourseContent(id, ccDto.getContent());;
        return ResponseEntity.noContent().build();
    }


    @GetMapping(path="/{id}/content")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CourseContentDto>> getAllCourseContentDtoById(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.courseService.getAllCourseContent(id));
    }
 
}
