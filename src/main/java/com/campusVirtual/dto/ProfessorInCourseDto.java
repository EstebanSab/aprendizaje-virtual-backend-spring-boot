package com.campusVirtual.dto;

public class ProfessorInCourseDto {
    private Long id;
    private Long  profesorId;
    private Long cursoId;
    private String profesorNombre;
    private String cursoNombre;

    public ProfessorInCourseDto(){ }


    public void setId(Long id) {
        this.id = id;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }


    public Long getId() {
        return this.id;
    }

    public Long getProfesorId() {
        return this.profesorId;
    }

    public Long getCursoId() {
        return this.cursoId;
    }
    
    public String getProfesorNombre() {
        return this.profesorNombre;
    }

    public String getCursoNombre() {
        return this.cursoNombre;
    }
    
}