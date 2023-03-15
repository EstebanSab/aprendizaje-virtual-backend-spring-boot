package com.campusVirtual.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.StudentDto;
import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.exception.CursoNotFoundException;
import com.campusVirtual.mapper.AlumnoMapper;
import com.campusVirtual.mapper.CourseMapper;
import com.campusVirtual.mapper.ProfesorMapper;
import com.campusVirtual.model.Student;
import com.campusVirtual.model.StudentInCourse;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.Professor;
import com.campusVirtual.model.ProfessorInCourse;
import com.campusVirtual.repository.CursoRepository;
import com.campusVirtual.service.ICourseService;

@Service
public class CourseService implements ICourseService {

    private CourseMapper cursoMapper = new CourseMapper();
    private ProfesorMapper profesorMapper = new ProfesorMapper();
    private AlumnoMapper alumnoMapper = new AlumnoMapper();
    @Autowired
    private CursoRepository cursoRepository;

   

    @Override
    public CourseDto saveCursoDto(CourseDto cursoDto) {
       Course nuevoCurso = cursoMapper.cursoDtoToCurso(cursoDto);
       nuevoCurso = this.cursoRepository.save(nuevoCurso);

       CourseDto cursoDtos=this.cursoMapper.cursoToCursoDto(nuevoCurso);
    
        return cursoDtos;
    }

    @Override
    public Course saveCursoNoDto(Course curso){
        return this.cursoRepository.save(curso);
    }

    @Override
    public Course getCursoNoDtoById(Long id){
        return this.cursoRepository.findById(id).orElseThrow(()-> new CursoNotFoundException(id));
    }

    @Override
    public CourseDto getCursoDtoById(Long id){
        Course curso = this.cursoRepository.findById(id).orElseThrow(()-> new CursoNotFoundException(id));;
        return cursoMapper.cursoToCursoDto(curso); 
    }

    @Override
    public List<CourseDto> getAllCursosDto(){
        List<CourseDto> cursoDto = cursoMapper.manyCursoToCursoDto(
            this.cursoRepository.findAll());
        
      return cursoDto; 
    } 

    @Override
    public void deleteCursoById(Long idCurso){
        if(this.cursoRepository.existsById(idCurso)){
            this.cursoRepository.deleteById(idCurso);
        }else{
            throw new CursoNotFoundException(idCurso);
        }
    }

    @Override
    public boolean existsCursoById(Long idCurso) {
        return this.cursoRepository.existsById(idCurso);
    }

   

    @Override
    public List<ProfessorDto> getAllProfesoresOfCurso(Long idCurso) {
        Course curso = this.cursoRepository.findById(idCurso).orElseThrow(()-> new CursoNotFoundException(idCurso));
        
        List<ProfessorInCourse> profesoresRelacion=curso.getProfesorEnCurso();
        
        List<Professor> profesores=new ArrayList<>();
        for (ProfessorInCourse profesor : profesoresRelacion) {
            profesores.add(profesor.getProfesor());
        }
        return this.profesorMapper.manyProfesorToProfesorDto(profesores);
    }

    @Override
    public List<StudentDto> getAllAlumnosOfCurso(Long idCurso) {
        Course curso = this.cursoRepository.findById(idCurso).orElseThrow(()-> new CursoNotFoundException(idCurso));
        
        List<StudentInCourse> alumnosRelacion=curso.getAlumnoEnCurso();
        
        List<Student> alumnos=new ArrayList<>();
        for (StudentInCourse alumno : alumnosRelacion) {
            alumnos.add(alumno.getAlumno());
        }
        return this.alumnoMapper.manyAlumnoToAlumnoDto(alumnos);
    }

   
    
}
