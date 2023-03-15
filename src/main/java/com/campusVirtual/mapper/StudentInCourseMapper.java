package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import com.campusVirtual.dto.StudentInCourseDto;
import com.campusVirtual.model.StudentInCourse;

public class StudentInCourseMapper {
    
    
    public StudentInCourseDto  alumnoEnCursoToDto(StudentInCourseDto aecNoDto){
        StudentInCourseDto  aecdto=new StudentInCourseDto();
        aecdto.setId(aecNoDto.getId());
        aecdto.setAlumnoId(aecNoDto.getAlumno().getId());
        aecdto.setAlumnoNombre(aecNoDto.getAlumno().getUserCredentials().getNombre());
        aecdto.setCursoId(aecNoDto.getCurso().getId());
        aecdto.setCursoNombre(aecNoDto.getCurso().getNombre());

        return aecdto;
    }



    public List<StudentInCourseDto> manyAlumnoEnCursoToDto(List<StudentInCourseDto> aecNoDtos) {
        List<StudentInCourseDto> aecdtos = new ArrayList<>();

        for (StudentInCourseDto alumnoEnCurso : aecNoDtos) {
            aecdtos.add(alumnoEnCursoToDto(alumnoEnCurso));
        }

        return aecdtos;
    }


    
}
