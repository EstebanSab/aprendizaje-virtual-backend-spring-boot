package com.campusVirtual.dto;

public class StudentInCourseDto {
    private Long id;
    private Long  alumnoId;
    private Long cursoId;
    private String alumnoNombre;
    private String cursoNombre;

    public StudentInCourseDto(){ }


    public void setId(Long id) {
        this.id = id;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }


    public Long getId() {
        return this.id;
    }

    public Long getAlumnoId() {
        return this.alumnoId;
    }

    public Long getCursoId() {
        return this.cursoId;
    }
    
    public String getAlumnoNombre() {
        return this.alumnoNombre;
    }

    public String getCursoNombre() {
        return this.cursoNombre;
    }
    
}
