package com.campusVirtual.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.campusVirtual.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long>{
    
}
