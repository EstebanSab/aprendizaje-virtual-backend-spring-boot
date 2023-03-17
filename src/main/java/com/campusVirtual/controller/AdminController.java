package com.campusVirtual.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.model.StudentInCourse;
import com.campusVirtual.service.IAdminService;
import com.campusVirtual.service.IStudentInCourseService;
import com.campusVirtual.service.IProfessorInCourseService;



@RestController
@RequestMapping(path="v1/admin")
public class AdminController {
    
    @Autowired
    private IProfessorInCourseService picService;
    @Autowired
    private IStudentInCourseService sicService;
    @Autowired
    private IAdminService adminService;


    @PostMapping(path ="/set/professor/{idProfessor}/course/{idCourse}")
    public ResponseEntity<?> asignarProfesorCurso(
        @PathVariable("idProfessor") Long idProfessor,
        @PathVariable("idCourse") Long idCourse){
            
           this.picService.setProfessorInCourse(idProfessor,idCourse);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

    @DeleteMapping(path ="/delete/professor/{idProfessor}/course/{idCourse}")
    public ResponseEntity<?> desvincularProfesorCurso(
        @PathVariable("idProfessor") Long idProfessor,
        @PathVariable("idCourse") Long idCourse){
            
            this.picService.deleteProfessorInCourse(idProfessor,idCourse);
            return ResponseEntity.noContent().build();
        }



    
    @PostMapping(path ="set/student/{idStudent}/course/{idCourse}")
    public ResponseEntity<StudentInCourse> asignarAlumnoCurso(
        @PathVariable("idStudent") Long idStudent,
        @PathVariable("idCourse") Long idCourse){
            
            return  ResponseEntity.status(HttpStatus.CREATED)
            .body(this.sicService.setStudentInCourse(idStudent,idCourse));
    }

    @DeleteMapping(path ="/delete/student/{idStudent}/course/{idCourse}")
    public ResponseEntity<?> desvincularAlumnoCurso(
        @PathVariable("idStudent") Long idStudent,
        @PathVariable("idCourse") Long idCourse){
            
        this.sicService.deleteStudentInCourse(idStudent,idCourse);
        return ResponseEntity.noContent().build();
    }
   
    @PostMapping(path ="user/{id}/role/admin")
    public void asignarRoleUser(
        @PathVariable("id") Long id){
         this.adminService.setRoleUser("ROLE_ADMIN", id);             
        }

        @PostMapping(path ="user/{id}/role/professor")
    public void asignarRoleProfessorUser(
        @PathVariable("id") Long id){
         this.adminService.setRoleUser("ROLE_PROFESSOR", id);             
        }
    


   
        
    

   



}
