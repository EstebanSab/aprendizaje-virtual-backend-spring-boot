package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.model.Professor;

public interface IProfessorService {
    
    public Professor saveProfesorNoDto(Professor profesor);
    
    public Professor getProfesorNoDtoById(Long id);
    
    public ProfessorDto saveProfesorDto(ProfessorDto profesorDto);
    
    public ProfessorDto getProfesorDtoById(Long id);

    public List<ProfessorDto> getAllProfesorDto();

    public List<CourseDto> getAllCursosProfesor(Long idProfesor);

    public void deleteProfesorById(Long idProfesor);

    public boolean existsProfesorById(Long idProfesor);
}
