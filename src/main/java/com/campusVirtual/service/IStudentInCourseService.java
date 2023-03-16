package com.campusVirtual.service;

import com.campusVirtual.model.StudentInCourse;

public interface IStudentInCourseService{
    public StudentInCourse setStudentInCourse(Long idStudent,Long idCourse);
        
    public void deleteStudentInCourse(Long idStudent,Long idCourse);
       
}