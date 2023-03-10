package com.campusVirtual.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.AlumnoEnCursoDto;
import com.campusVirtual.dto.ProfesorEnCursoDto;
import com.campusVirtual.service.IAdminService;
import com.campusVirtual.service.IAlumnoEnCursoService;
import com.campusVirtual.service.IProfesorEnCursoService;



@RestController
@RequestMapping(path="v1/admin")
public class AdminController {
    
    @Autowired
    private IProfesorEnCursoService profesorEnCursoService;
    @Autowired
    private IAlumnoEnCursoService alumnoEnCursoService;
    @Autowired
    private IAdminService adminService;


    @PostMapping(path ="/asignar/profesor/{idProfesor}/curso/{idCurso}")
    public ResponseEntity<ProfesorEnCursoDto> asignarProfesorCurso(
        @PathVariable("idProfesor") Long idProfesor,
        @PathVariable("idCurso") Long idCurso){
            
            return  ResponseEntity.status(HttpStatus.CREATED)
            .body(this.profesorEnCursoService.asignarProfesorCurso(idProfesor,idCurso));
    }

    @DeleteMapping(path ="/desvincular/profesor/{idProfesor}/curso/{idCurso}")
    public ResponseEntity<?> desvincularProfesorCurso(
        @PathVariable("idProfesor") Long idProfesor,
        @PathVariable("idCurso") Long idCurso){
            
            this.profesorEnCursoService.desvincularProfesorCurso(idProfesor,idCurso);
            return ResponseEntity.noContent().build();
        }



    
    @PostMapping(path ="asingnar/alumno/{idAlumno}/curso/{idCurso}")
    public ResponseEntity<AlumnoEnCursoDto> asignarAlumnoCurso(
        @PathVariable("idAlumno") Long idAlumno,
        @PathVariable("idCurso") Long idCurso){
            
            return  ResponseEntity.status(HttpStatus.CREATED)
            .body(this.alumnoEnCursoService.asignarAlumnoCurso(idAlumno,idCurso));
    }

    @DeleteMapping(path ="/desvincular/alumno/{idAlumno}/curso/{idCurso}")
    public ResponseEntity<?> desvincularAlumnoCurso(
        @PathVariable("idAlumno") Long idAlumno,
        @PathVariable("idCurso") Long idCurso){
            
        this.alumnoEnCursoService.desvincularAlumnoCurso(idAlumno,idCurso);
        return ResponseEntity.noContent().build();
    }
   
    @PostMapping(path ="user/{id}/role/admin")
    public void asignarRoleUser(
        @PathVariable("id") Long id){
         this.adminService.asignarRoleUser("ROLE_ADMIN", id);             
        }
    


   
        
    

   



}
