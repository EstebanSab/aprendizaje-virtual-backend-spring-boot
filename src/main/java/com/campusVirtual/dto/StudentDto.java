package com.campusVirtual.dto;

public class StudentDto {
    private Long id;
    private String nombre;
    

    public StudentDto(){}
    public StudentDto(
        Long id,
        String nombre){
            this.id=id;
            this.nombre=nombre;
        }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

}
