package com.campusVirtual.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.exception.ProfesorNotFoundException;
import com.campusVirtual.model.Professor;
import com.campusVirtual.repository.ProfessorRepository;
import com.campusVirtual.service.IProfessorService;
import com.campusVirtual.service.IUserDataService;

@Service
public class ProfessorService implements IProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private IUserDataService userDataService; 

    @Override
    public void saveProfessor(Professor professor, Long document) {
        Professor profesorSet = this.professorRepository.save(professor);
        profesorSet.setUser(this.userDataService.getUserById(document));
        this.professorRepository.save(profesorSet);
    }

    @Override
    public Professor getProfessorById(Long idProfessor) {
      return  this.professorRepository.findById(idProfessor).get();
    }

    @Override
    public List<Professor> getAllProfessors() {
        return  this.professorRepository.findAll();  
    }

    @Override
    public List<CourseDto> getAllCoursesProfessor(Long idProfessor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCoursesProfessor'");
    }

    @Override
    public boolean existProfessorById(Long idProfessor) {
      return this.professorRepository.existsById(idProfessor);
    }

    @Override
    public void deleteProfessorById(Long idProfessor) {
        if(this.professorRepository.existsById(idProfessor)){
            this.professorRepository.deleteById(idProfessor);
        }else{
            throw new ProfesorNotFoundException(idProfessor);
        }
    }
    
   
}
