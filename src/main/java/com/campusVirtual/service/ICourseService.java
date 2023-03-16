package com.campusVirtual.service;

import java.util.List;


import com.campusVirtual.model.Course;
import com.campusVirtual.model.Professor;
import com.campusVirtual.model.Student;

public interface ICourseService {
    
    
    public Course saveCourse(Course course);
    public Course getCourseById(Long idCoursed);
    public List<Course> getAllCourses();
    public void deleteCursoById(Long idCourse);
    public boolean existsCursoById(Long idCourse);
    public List<Professor> getAllProfessorsOfCourse(Long idCourse);
    public List<Student> getAllStudentsOfCourse(Long idCourse);
     
     
}
