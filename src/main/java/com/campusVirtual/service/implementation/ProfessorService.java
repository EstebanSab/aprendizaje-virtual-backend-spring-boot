package com.campusVirtual.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.exception.ObjectNotFoundException;
import com.campusVirtual.mapper.ProfessorMapper;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.Professor;
import com.campusVirtual.model.ProfessorInCourse;
import com.campusVirtual.model.Userdata;
import com.campusVirtual.repository.ProfessorRepository;
import com.campusVirtual.service.ICourseService;
import com.campusVirtual.service.IProfessorService;
import com.campusVirtual.service.IUserDataService;

@Service
public class ProfessorService implements IProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private IUserDataService userDataService; 

    @Autowired
    private ICourseService courseService;

    private ProfessorMapper pMapper = new ProfessorMapper();

    @Override
    public ProfessorDto saveProfessor(String username) {
        //Professor profesorSet = new Professor(professorDto.getEspeciality());

        Professor profesorSet = this.professorRepository.save(new Professor());

        profesorSet.setUser(this.userDataService.getUserById(username));
        
        profesorSet = this.professorRepository.save(profesorSet);

        return pMapper.professorToProfessorDto(profesorSet);
    }

    @Override
    public Professor getProfessorById(Long idProfessor) {
      return  this.professorRepository.findById(idProfessor).orElseThrow(()-> new ObjectNotFoundException("Professor",idProfessor));
    }

    @Override
    public ProfessorDto getProfessorDtoById(Long idProfessor) {
      return pMapper.professorToProfessorDto(getProfessorById(idProfessor));
    }

    @Override
    public List<Professor> getAllProfessors() {
        return  this.professorRepository.findAll();  
    }

    @Override
    public List<ProfessorDto> getAllProfessorsDto() {
        return  pMapper.manyProfessorToProfessorDto(getAllProfessors());  
    }
    

    @Override
    public List<ProfessorDto> getAllProfessorsOfCourse(Long idCourse) {
        Course course = this.courseService.getCourseById(idCourse);

        List<ProfessorInCourse> professorsRelation=course.getProfessorInCourse();
        
        List<Professor> professors=new ArrayList<>();
        for (ProfessorInCourse professor : professorsRelation) {
            professors.add(professor.getProfessor());
        }
        return this.pMapper.manyProfessorToProfessorDto(professors);
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
            throw new  ObjectNotFoundException("Professor",idProfessor);
        }
    }

    @Override
    public ProfessorDto getProfessorDtoByUsername(String username) {
        Userdata ud =this.userDataService.getUserById(username);
       return this.getProfessorDtoById(ud.getProfessor().getId());
    }
    
   
}
