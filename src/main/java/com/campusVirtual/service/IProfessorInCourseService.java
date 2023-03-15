package com.campusVirtual.service;

import com.campusVirtual.dto.ProfessorInCourseDto;

public interface IProfessorInCourseService {

    public ProfessorInCourseDto asignarProfesorCurso(Long idProfesor,Long Idcurso);
        
    public void desvincularProfesorCurso(Long idProfesor, Long idCurso);
        
}
