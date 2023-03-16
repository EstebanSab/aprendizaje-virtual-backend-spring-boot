package com.campusVirtual.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.campusVirtual.model.Student;
import com.campusVirtual.model.StudentInCourse;
import com.campusVirtual.model.Course;
import com.campusVirtual.repository.StudentInCourseRepository;
import com.campusVirtual.service.IStudentInCourseService;
import com.campusVirtual.service.IStudentService;
import com.campusVirtual.service.ICourseService;

@Service
public class StudentInCourseService  implements IStudentInCourseService{
    
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private StudentInCourseRepository sicRepository;

   

    @Override
    public StudentInCourse setStudentInCourse(Long idStudent, Long idCourse) {
        Student student= this.studentService.getStudentById(idStudent);
        Course course=this.courseService.getCourseById(idCourse);
        return this.sicRepository.save(new StudentInCourse(student,course));
    }
    @Override
    public void deleteStudentInCourse(Long idStudent, Long idCourse) {
        this.sicRepository.deleteStudentInCourseByBothId(idStudent,idCourse);
    }
}

    

   


