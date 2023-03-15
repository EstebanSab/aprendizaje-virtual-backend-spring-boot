package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.model.Student;

public interface IStudentService {
    
    public Student saveStudent(Student student,Long document);

    public Student getSudentById(Long idStudent);

    public Student getSudentDtoById(Long idStudent);

    public List<Student> getAllStudents();

    public List<Student> getAllStudentsDto();

    public List<CourseDto> getAllCoursesStudent(Long idStudent);

    public boolean existStudentById(Long idStudent);
        
}


