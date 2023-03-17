package com.campusVirtual.dto;


import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
public class CourseDto {
    
    private Long id;
    private String name;


    public CourseDto(){}
    public CourseDto(String name){
        this.name = name;
    }

    
}
