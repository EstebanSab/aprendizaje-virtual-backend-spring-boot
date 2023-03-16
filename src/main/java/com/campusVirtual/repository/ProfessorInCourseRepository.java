package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.campusVirtual.model.ProfessorInCourse;

public interface ProfessorInCourseRepository extends JpaRepository<ProfessorInCourse,Long>{

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM ProfesorEnCurso pec where pec.profesor_id = ?1 and pec.curso_id = ?2",
    nativeQuery = true)
    void deleteProfessorInCourseByBothId(Long idProfessor, Long idCourse);
    
}
