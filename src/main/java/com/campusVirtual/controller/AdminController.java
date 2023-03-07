package com.campusVirtual.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.AlumnoEnCursoDto;
import com.campusVirtual.dto.ProfesorEnCursoDto;
import com.campusVirtual.service.AlumnoEnCursoService;
import com.campusVirtual.service.ProfesorEnCursoService;



@RestController
@RequestMapping(path="v1/admin")
public class AdminController {

    private ProfesorEnCursoService profesorEnCursoService;
    private AlumnoEnCursoService alumnoEnCursoService;

    @Autowired
    public AdminController(
        ProfesorEnCursoService profesorEnCursoService,
        AlumnoEnCursoService alumnoEnCursoService){
            this.profesorEnCursoService=profesorEnCursoService;
            this.alumnoEnCursoService=alumnoEnCursoService;
    }
  

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
            
        this.alumnoEnCursoService.desvincularProfesorCurso(idAlumno,idCurso);
        return ResponseEntity.noContent().build();
    }
   

    


   
        
    

   



}
