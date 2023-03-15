package com.campusVirtual.model;

import javax.persistence.*;

@Entity(name="AlumnoEnCurso")
@Table(
    name="alumnoencurso",
    uniqueConstraints = {
        @UniqueConstraint(
            name="alumnoencuros_id_constraint",columnNames = "id"
        )
    }
)
public class StudentInCourse {
    @Id
        @SequenceGenerator(
            name = "generadoIdAlumnoEnCurso",
            sequenceName = "ALUMNOENCURSO_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdAlumnoEnCurso",
            strategy = GenerationType.SEQUENCE)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;


        @ManyToOne()
        @JoinColumn(
            name="alumno_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = 
                @ForeignKey(name="alumno_curso_id")
            
        )
        private Student alumno;


        @ManyToOne()
        @JoinColumn(
            name="curso_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = 
                @ForeignKey(name="curso_alumno_id")
            
        )
        private Course curso;


        public StudentInCourse(){}

        public void setAlumno(Student alumno) {
            this.alumno = alumno;
        }
        public void setCurso(Course curso) {
            this.curso = curso;
        }
        
        public void setId(Long id) {
            this.id = id;
        }

        public Student getAlumno() {
            return alumno;
        }

        public Course getCurso() {
            return curso;
        }

        public Long getId() {
            return this.id;
        }

        @Override
        public String toString() {
            return ""+this.alumno+""+this.curso;
        }


    
}
