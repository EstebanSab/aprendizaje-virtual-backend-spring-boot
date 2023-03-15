package com.campusVirtual.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.exception.ProfesorNotFoundException;
import com.campusVirtual.mapper.ProfesorMapper;
import com.campusVirtual.mapper.CourseMapper;
import com.campusVirtual.model.Professor;
import com.campusVirtual.repository.ProfessorRepository;
import com.campusVirtual.service.IProfessorService;

@Service
public class ProfessorService implements IProfessorService{
    
    @Autowired
    ProfessorRepository profesorRepository;
    ProfesorMapper profesorMapper = new ProfesorMapper();
    private CourseMapper cursoMapper = new CourseMapper();


    @Override
    public Professor saveProfesorNoDto(Professor profesor) {
        return this.profesorRepository.save(profesor);
    }
    
    @Override
    public Professor getProfesorNoDtoById(Long id) {
        return this.profesorRepository.findById(id).orElseThrow(()-> new ProfesorNotFoundException(id));
    }
    
    @Override
    public ProfessorDto saveProfesorDto(ProfessorDto profesorDto) {
        Professor profesor = this.profesorMapper.profesorDtoToProfesor(profesorDto);
        
        profesor = this.profesorRepository.save(profesor);

        ProfessorDto profesorDtoCreado = this.profesorMapper.profesorToProfesorDto(profesor);
        
        return profesorDtoCreado;
    }
    
    @Override
    public ProfessorDto getProfesorDtoById(Long id) {
        Professor profesor= this.profesorRepository.findById(id).orElseThrow(()-> new ProfesorNotFoundException(id));
        
        ProfessorDto profesorDto =  profesorMapper.profesorToProfesorDto(profesor);
        
        return profesorDto;
    }

    @Override
    public List<ProfessorDto> getAllProfesorDto(){
        List<Professor> profesores =this.profesorRepository.findAll();
        
        List<ProfessorDto> profesoresDto = profesorMapper.manyProfesorToProfesorDto(profesores);
        
        return profesoresDto;
    }

    @Override
    public List<CourseDto> getAllCursosProfesor(Long idProfesor){
        Professor profesorById = this.profesorRepository.findById(idProfesor).get();
        
        List<CourseDto> cursosProfesorById= cursoMapper.manyProfesorEnCursoToCursoDto(profesorById.getProfesorEnCurso()); 
        
        return cursosProfesorById;
    }

    @Override
    public void deleteProfesorById(Long idProfesor){
        if(this.profesorRepository.existsById(idProfesor)){
            this.profesorRepository.deleteById(idProfesor);
        }else{
            throw new ProfesorNotFoundException(idProfesor);
        }
        
    }

    @Override
    public boolean existsProfesorById(Long idProfesor) {
        return this.profesorRepository.existsById(idProfesor);
    }
}
