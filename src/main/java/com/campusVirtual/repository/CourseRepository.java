package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusVirtual.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
    
}
