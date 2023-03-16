package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.model.Student;

public interface IStudentService {
    
    public void saveStudent(Student student,Long document);

    public Student getStudentById(Long idStudent);

    public List<Student> getAllStudents();
    
    public List<CourseDto> getAllCoursesStudent(Long idStudent);

    public boolean existStudentById(Long idStudent);
    
    public void deleteStudentById(Long idStudent);
}


