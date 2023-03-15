package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import com.campusVirtual.dto.ProfessorInCourseDto;
import com.campusVirtual.model.ProfessorInCourse;

public class ProfessorInCourseMapper {
    public ProfessorInCourseDto profesorEnCursoToDto(ProfessorInCourse profesorEnCurso){
       ProfessorInCourseDto pecdto = new ProfessorInCourseDto();

        pecdto.setId(profesorEnCurso.getId());
        pecdto.setProfesorId(profesorEnCurso.getProfesor().getId());
        pecdto.setCursoId(profesorEnCurso.getCurso().getId());
        pecdto.setProfesorNombre(profesorEnCurso.getProfesor().getNombre());
        pecdto.setCursoNombre(profesorEnCurso.getCurso().getNombre());
        return pecdto;
    }

    public List<ProfessorInCourseDto> manyProfesorEnCursoToDto(List<ProfessorInCourse> pecs) {
       List<ProfessorInCourseDto> profesorEnCursoDtos =new ArrayList<>();
       
        for (ProfessorInCourse profesorEnCurso : pecs) {
            profesorEnCursoDtos.add(profesorEnCursoToDto(profesorEnCurso));
       }
       return profesorEnCursoDtos;
    }
}
