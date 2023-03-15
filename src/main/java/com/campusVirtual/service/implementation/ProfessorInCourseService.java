package com.campusVirtual.service.implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.ProfessorInCourseDto;
import com.campusVirtual.exception.CursoNotFoundException;
import com.campusVirtual.exception.ProfesorNotFoundException;
import com.campusVirtual.mapper.ProfessorInCourseMapper;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.ProfessorInCourse;
import com.campusVirtual.model.Professor;
import com.campusVirtual.repository.ProfessorInCourseRepository;
import com.campusVirtual.service.ICourseService;
import com.campusVirtual.service.IProfessorInCourseService;
import com.campusVirtual.service.IProfessorService;

@Service
public class ProfessorInCourseService implements IProfessorInCourseService{
    @Autowired
    private ProfessorInCourseRepository profesorEnCursoRepository;
    @Autowired
    private IProfessorService profesorService;
    @Autowired
    private ICourseService cursoService;
    private ProfessorInCourseMapper pecMapper= new ProfessorInCourseMapper();
    

    

    //public ProfesorEnCurso asignarProfesorCurso(Profesor profesor,Curso curso){
    //    ProfesorEnCurso ensenia = new ProfesorEnCurso(profesor, curso);
    //    return this.profesorEnCursoRepository.save(ensenia);
    //}

    @Override
    public ProfessorInCourseDto asignarProfesorCurso(Long idProfesor,Long Idcurso){
        Professor profesorPorId=profesorService.getProfesorNoDtoById(idProfesor);
        Course cursoPorId=cursoService.getCursoNoDtoById(Idcurso);
        
        ProfessorInCourse profesorCursoRelacion = new ProfessorInCourse(profesorPorId, cursoPorId);
        profesorCursoRelacion =  this.profesorEnCursoRepository.save(profesorCursoRelacion);

        profesorPorId.addProfesorEnCurso(profesorCursoRelacion);
        cursoPorId.addProfesorEnCurso(profesorCursoRelacion);

        profesorService.saveProfesorNoDto(profesorPorId);
        cursoService.saveCursoNoDto(cursoPorId); 

        return  pecMapper.profesorEnCursoToDto(profesorCursoRelacion);  
    }

    @Override
    public void desvincularProfesorCurso(Long idProfesor, Long idCurso) {
        if(!this.profesorService.existsProfesorById(idProfesor)){
            throw new ProfesorNotFoundException(idCurso);
        }

        if(!this.cursoService.existsCursoById(idCurso)){
            throw new CursoNotFoundException(idCurso);
        }
        this.profesorEnCursoRepository.deleteProfesorEnCursoByBothId(idProfesor,idCurso);
    }
}
