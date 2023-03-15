package com.campusVirtual.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.campusVirtual.mapper.AlumnoMapper;
import com.campusVirtual.mapper.CourseMapper;
import com.campusVirtual.dto.StudentDto;
import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.exception.AlumnoNotFoundException;
import com.campusVirtual.model.Student;
import com.campusVirtual.repository.StudentRepository;
import com.campusVirtual.service.IStudentService;
import com.campusVirtual.service.IUserCredentialsService;

@Service
public class StudentService implements IStudentService {
    private AlumnoMapper alumnoMapper = new AlumnoMapper();
    private CourseMapper cursoMapper = new CourseMapper();

    @Autowired
    private StudentRepository alumnoRepository;

    @Autowired
    private IUserCredentialsService userService;

  

    @Override
    public Student saveStudent(Student student){
        return this.studentRepository.save(student);
    }

    @Override
    public Student getAlumnoNoDtoById(Long idAlumno){
       return this.alumnoRepository.findById(idAlumno).orElseThrow(()-> new AlumnoNotFoundException(idAlumno));
    }

    @Override
    public StudentDto saveAlumnoDto(StudentDto alumnoDto){
        Student alumno= this.alumnoMapper.alumnoDtoToAlumno(alumnoDto);

        alumno = this.alumnoRepository.save(alumno);

        return this.alumnoMapper.alumnoToAlumnoDto(alumno);
    }

    @Override
    public StudentDto getAlumnoDtoById(Long idAlumno){
        Student alumno = this.alumnoRepository.findById(idAlumno).orElseThrow(()-> new AlumnoNotFoundException(idAlumno));
        
        StudentDto alumnoDto = this.alumnoMapper.alumnoToAlumnoDto(alumno);

        return alumnoDto;
    }


    @Override
    public List<StudentDto> getAllAlumnoDto(){
        List<Student> alumnos= this.alumnoRepository.findAll();
        
        List<StudentDto> alumnosDto = this.alumnoMapper.manyAlumnoToAlumnoDto(alumnos);

        return alumnosDto;
    }

    @Override
    public List<CourseDto> getAllCursosAlumno(Long idAlumno){
        Student alumno = this.alumnoRepository.findById(idAlumno).orElseThrow(()-> new AlumnoNotFoundException(idAlumno));
        
        List<CourseDto> cursosAlumnoById= cursoMapper.manyAlumnoEnCursoToCursoDto(alumno.getAlumnoEnCurso()); 
        
        return cursosAlumnoById;
    }
    
    @Override
    public void deleteAlumnoById(Long idAlumno){
        if(this.alumnoRepository.existsById(idAlumno)){
            this.alumnoRepository.deleteById(idAlumno);
        }else{
            throw new AlumnoNotFoundException(idAlumno);
        }
    }

    @Override
    public boolean existsAlumnoById(Long idAlumno) {
        return this.alumnoRepository.existsById(idAlumno);
    }
}
