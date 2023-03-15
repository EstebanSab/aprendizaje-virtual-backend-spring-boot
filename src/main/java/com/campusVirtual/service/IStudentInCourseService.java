package com.campusVirtual.service;

import com.campusVirtual.dto.StudentInCourseDto;

public interface IStudentInCourseService{
    public StudentInCourseDto asignarAlumnoCurso(Long alumnoId,Long cursoId);
    
    public void desvincularAlumnoCurso(Long idAlumno, Long idCurso);
       
}