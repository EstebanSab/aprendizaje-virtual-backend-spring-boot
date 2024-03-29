package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.StudentDto;
import com.campusVirtual.model.Student;

public interface IStudentService {
    
    public StudentDto saveStudent(String username);
    
    public Student getStudentById(Long idStudent);

    public StudentDto getStudentDtoById(Long idStudent);

    public StudentDto getStudentDtoByUsername(String username);

    public List<Student> getAllStudents();

    public List<StudentDto>getAllStudentsDto();

    public List<StudentDto> getAllStudentsOfCourse(Long idCourse);

    public boolean existStudentById(Long idStudent);
    
    public void deleteStudentById(Long idStudent);

}


