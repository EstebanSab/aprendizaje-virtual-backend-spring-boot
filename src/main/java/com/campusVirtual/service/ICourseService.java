package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.StudentDto;
import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.model.Course;

public interface ICourseService {
    
    public CourseDto saveCursoDto(CourseDto cursoDto) ;
 
     public Course saveCursoNoDto(Course curso);
 
     public Course getCursoNoDtoById(Long id);
 
     public CourseDto getCursoDtoById(Long id);

     public List<CourseDto> getAllCursosDto();
 
     public void deleteCursoById(Long idCurso);
     
     public boolean existsCursoById(Long idCurso);

     public List<ProfessorDto> getAllProfesoresOfCurso(Long idCurso);

     public List<StudentDto> getAllAlumnosOfCurso(Long idCurso);
     
}
