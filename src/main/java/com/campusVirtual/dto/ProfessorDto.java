package com.campusVirtual.dto;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfessorDto {
    private Long id;
    private String nombre;
    private String especialidad;

    public ProfessorDto(){}
   

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

}
