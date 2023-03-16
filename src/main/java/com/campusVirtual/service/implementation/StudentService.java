package com.campusVirtual.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.exception.AlumnoNotFoundException;
import com.campusVirtual.model.Student;
import com.campusVirtual.repository.StudentRepository;
import com.campusVirtual.service.IStudentService;
import com.campusVirtual.service.IUserDataService;



@Service
public class StudentService implements IStudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private IUserDataService userDataService;   

    @Override
    public void saveStudent(Student student, Long document) {
        Student studentSet = this.studentRepository.save(student);
        studentSet.setUser(this.userDataService.getUserById(document));
        this.studentRepository.save(studentSet);
    }

    @Override
    public Student getStudentById(Long idStudent) {
        return this.studentRepository.findById(idStudent).get();
    }



    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }


    @Override
    public List<CourseDto> getAllCoursesStudent(Long idStudent) {
        Student alumno = this.studentRepository.findById(idStudent).orElseThrow(()-> new AlumnoNotFoundException(idStudent));
        
        //List<CourseDto> cursosAlumnoById= cursoMapper.manyAlumnoEnCursoToCursoDto(alumno.getAlumnoEnCurso()); 
        
        //return cursosAlumnoById;
        
        throw new UnsupportedOperationException("Unimplemented method 'getAllCoursesStudent'");
    }

    @Override
    public boolean existStudentById(Long idStudent) {
        return this.studentRepository.existsById(idStudent);
    }

    @Override
    public void deleteStudentById(Long idAlumno){
        if(this.studentRepository.existsById(idAlumno)){
            this.studentRepository.deleteById(idAlumno);
        }else{
            throw new AlumnoNotFoundException(idAlumno);
        }
    }
}
