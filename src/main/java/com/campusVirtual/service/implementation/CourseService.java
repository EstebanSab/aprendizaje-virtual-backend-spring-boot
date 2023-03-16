package com.campusVirtual.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.campusVirtual.exception.CursoNotFoundException;
import com.campusVirtual.model.Student;
import com.campusVirtual.model.StudentInCourse;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.Professor;
import com.campusVirtual.model.ProfessorInCourse;
import com.campusVirtual.repository.CourseRepository;
import com.campusVirtual.service.ICourseService;

@Service
public class CourseService implements ICourseService {

    
    @Autowired
    private CourseRepository courseRepository;

   

   

    @Override
    public Course saveCourse(Course course){
        return this.courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id){
        return this.courseRepository.findById(id).orElseThrow(()-> new CursoNotFoundException(id));
    }


    @Override
    public List<Course> getAllCourses(){
        return this.courseRepository.findAll();
        }

    @Override
    public void deleteCursoById(Long idCourse){
        if(this.courseRepository.existsById(idCourse)){
            this.courseRepository.deleteById(idCourse);
        }else{
            throw new CursoNotFoundException(idCourse);
        }
    }

    @Override
    public boolean existsCursoById(Long idCourse) {
        return this.courseRepository.existsById(idCourse);
    }

   

    @Override
    public List<Professor> getAllProfessorsOfCourse(Long idCourse) {
        Course course = this.courseRepository.findById(idCourse).orElseThrow(()-> new CursoNotFoundException(idCourse));
        
        List<ProfessorInCourse> professorsRelation=course.getProfessorInCourse();
        
        List<Professor> professors=new ArrayList<>();
        for (ProfessorInCourse professor : professorsRelation) {
            professors.add(professor.getProfessor());
        }
        return professors;
    }

    @Override
    public List<Student> getAllStudentsOfCourse(Long idCourse) {
        Course course = this.courseRepository.findById(idCourse).orElseThrow(()-> new CursoNotFoundException(idCourse));
        
        List<StudentInCourse> studentsRelation=course.getStudentInCourse();
        
        List<Student> students=new ArrayList<>();
        for (StudentInCourse studentR : studentsRelation) {
            students.add(studentR.getStudent());
        }
        return students;
    }



   
    
}
