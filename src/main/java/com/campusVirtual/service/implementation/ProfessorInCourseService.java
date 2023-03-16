package com.campusVirtual.service.implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.campusVirtual.model.Course;
import com.campusVirtual.model.ProfessorInCourse;
import com.campusVirtual.model.Professor;
import com.campusVirtual.repository.ProfessorInCourseRepository;
import com.campusVirtual.service.ICourseService;
import com.campusVirtual.service.IProfessorInCourseService;
import com.campusVirtual.service.IProfessorService;

@Service
public class ProfessorInCourseService implements IProfessorInCourseService{
    @Autowired
    private ProfessorInCourseRepository picRepository;
    @Autowired
    private IProfessorService professorService;
    @Autowired
    private ICourseService courseService;
    
    
    @Override
    public void setProfessorInCourse(Long idProfessor, Long idCourse) {
        Professor professor= this.professorService.getProfessorById(idProfessor);
        Course course=this.courseService.getCourseById(idCourse);
        this.picRepository.save(new ProfessorInCourse(professor,course));
    }
    @Override
    public void deleteProfessorInCourse(Long idProfessor, Long idCourse) {
        this.picRepository.deleteProfessorInCourseByBothId(idProfessor,idCourse);
    }
    

}
