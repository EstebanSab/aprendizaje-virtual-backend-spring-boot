package com.campusVirtual.service;


public interface IProfessorInCourseService {

    public void setProfessorInCourse(Long idProfessor,Long idCourse);
        
    public void deleteProfessorInCourse(Long idProfessor,Long idCourse);
        
}
