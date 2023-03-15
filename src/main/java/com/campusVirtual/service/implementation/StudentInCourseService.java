package com.campusVirtual.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.StudentInCourseDto;
import com.campusVirtual.exception.AlumnoNotFoundException;
import com.campusVirtual.exception.CursoNotFoundException;
import com.campusVirtual.mapper.StudentInCourseMapper;
import com.campusVirtual.model.Student;
import com.campusVirtual.model.StudentInCourse;
import com.campusVirtual.model.Course;
import com.campusVirtual.repository.StudentInCourseRepository;
import com.campusVirtual.service.IStudentInCourseService;
import com.campusVirtual.service.IStudentService;
import com.campusVirtual.service.ICourseService;

@Service
public class StudentInCourseService  implements IStudentInCourseService{
    
    private StudentInCourseMapper alumnoEnCursoMapper = new StudentInCourseMapper();
    
    @Autowired
    private IStudentService alumnoService;
    @Autowired
    private ICourseService cursoService;
    @Autowired
    private StudentInCourseRepository alumnoEnCursoRepository;

   

    @Override
    public StudentInCourseDto asignarAlumnoCurso(Long alumnoId,Long cursoId){
        Student alumno = this.alumnoService.getAlumnoNoDtoById(alumnoId);
        Course curso = this.cursoService.getCursoNoDtoById(cursoId);

        StudentInCourseDto alumnoEnCurso = new StudentInCourseDto();
        alumnoEnCurso.setAlumno(alumno);
        alumnoEnCurso.setCurso(curso);

        alumnoEnCurso = this.alumnoEnCursoRepository.save(alumnoEnCurso);

        alumno.addAlumnoEnCurso(alumnoEnCurso);
        curso.addAlumnoEnCurso(alumnoEnCurso);

        cursoService.saveCursoNoDto(curso);
        alumnoService.saveAlumnoNoDto(alumno);
    
        return alumnoEnCursoMapper.alumnoEnCursoToDto(alumnoEnCurso);
    }

    @Override
    public void desvincularAlumnoCurso(Long idAlumno, Long idCurso) {
        if(!this.alumnoService.existsAlumnoById(idAlumno)){
            throw new AlumnoNotFoundException(idAlumno);
        }

        if(!this.cursoService.existsCursoById(idCurso)){
            throw new CursoNotFoundException(idCurso);
        }
       
        this.alumnoEnCursoRepository.deleteAlumnoEnCursoByBothId(idAlumno,idCurso);
    }
}

    

   


