package com.campusVirtual.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.ProfessorInCourse;
import com.campusVirtual.model.StudentInCourse;
import com.campusVirtual.service.ICourseService;


public class CourseMapper {

    @Autowired
    ICourseService courseService;




    public CourseDto courseToCourseDto(Course course){
        CourseDto cDto = new CourseDto();

        cDto.setId(course.getId());
        cDto.setName(course.getName());

        return cDto;

    }
    
    
    public List<CourseDto> manyCourseToCourseDto(List<Course>  courses) {
        List<CourseDto> coursesDtos = new ArrayList<>();
        
        for (Course course : courses) {
            coursesDtos.add(
                courseToCourseDto(course)
            );
        }

        return coursesDtos;
    }


    public List<CourseDto> manyStudentInCourseToCourseDto(List<StudentInCourse>  sics) {
        List<CourseDto> coursesDtos = new ArrayList<>();

        for (StudentInCourse studentInCourse : sics) {
            coursesDtos.add(
                courseToCourseDto(studentInCourse.getCourse())
            );
        }

        return coursesDtos;
    }
    
    public List<CourseDto> manyProfessorInCourseToCourseDto(List<ProfessorInCourse> pics){

        List<CourseDto> coursesDtos = new ArrayList<>();

        for (ProfessorInCourse professorInCourse : pics) {
            coursesDtos.add(
                courseToCourseDto(professorInCourse.getCourse())
            );
        }

        return coursesDtos;

    }


}
