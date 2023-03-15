package com.campusVirtual.dto;

public class CourseDto {
    
    private Long id;
    private String nombre;


    public CourseDto(){}
    public CourseDto(String nombre){
        this.nombre = nombre;
    }
    public CourseDto(Long id,String nombre){
        this.nombre = nombre;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
    
}
