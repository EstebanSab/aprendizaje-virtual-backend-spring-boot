package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.dto.ProfesorDto;
import com.campusVirtual.service.IProfesorService;

import java.util.List;

@RestController
@RequestMapping(path="v1/profesor")
public class ProfesorController {

    @Autowired
    private IProfesorService profesorService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProfesorDto> getProfesorDtoById(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(profesorService.getProfesorDtoById(id));
    }

    //@GetMapping(path = "/todos")
    //public ResponseEntity<List<ProfesorDto>> getAllProfesorDto(){
    //    return ResponseEntity.ok()
    //    .body(this.profesorService.getAllProfesorDto());
    //}


    @GetMapping(path ="/{id}/cursos")
    public ResponseEntity<List<CursoDto>> getAllCursosProfesor(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.profesorService.getAllCursosProfesor(id));
    }

    @PostMapping(path ="")
    public ResponseEntity<ProfesorDto> nuevoProfesor(
        @RequestBody ProfesorDto profesorDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.profesorService.saveProfesorDto(profesorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfesorById(@PathVariable("id") Long id){
        this.profesorService.deleteProfesorById(id);
        return ResponseEntity.noContent().build();
    }


}
