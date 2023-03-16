package com.campusVirtual.model;

import javax.persistence.*;
    
import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
    @Entity(name="ProfessorInCourse")
    @Table(
        name="professorincourse",
        uniqueConstraints = {
            @UniqueConstraint(
                    name="professorInCourse_id_constraint",
                    columnNames = "id")
        }
    )
    public class ProfessorInCourse {
        @Id
        @SequenceGenerator(
            name = "generadoIdProfessorInCourse",
            sequenceName = "PROFESSORINCOURSE_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdProfessorInCourse",
            strategy = GenerationType.SEQUENCE)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;
    


    @ManyToOne
    @JoinColumn(
            name = "professor_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "professor_course_fk"
            )
    )
    private Professor professor;

    @ManyToOne
    @JoinColumn(
            name = "course_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "course_professor_fk"
            )
    )
    private Course course;

        public ProfessorInCourse(){        }
        public ProfessorInCourse(Professor professor,Course course){
        this.professor = professor;
        this.course = course;
        }
        

}
