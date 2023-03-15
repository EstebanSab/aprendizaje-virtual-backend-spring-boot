package com.campusVirtual.model;

import javax.persistence.*;
    

    @Entity(name="ProfesorEnCurso")
    @Table(
        name="profesorencurso",
        uniqueConstraints = {
            @UniqueConstraint(
                    name="profesorencurso_id_constraint",
                    columnNames = "id")
        }
    )
    public class ProfessorInCourse {
        @Id
        @SequenceGenerator(
            name = "generadoIdProfesorEnCurso",
            sequenceName = "PROFESORENCURSO_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdProfesorEnCurso",
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
            name = "profesor_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "profesor_curso_fk"
            )
    )
    private Professor profesor;

    @ManyToOne
    @JoinColumn(
            name = "curso_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "curso_profesor_fk"
            )
    )
    private Course curso;

        public ProfessorInCourse(){        }
    public ProfessorInCourse(Professor profesor,Course curso){
        this.profesor = profesor;
        this.curso = curso;
        }
        
            public void setProfesor(Professor profesor){
                this.profesor = profesor;
            }

            public void setCurso(Course curso){
                this.curso = curso;
            }
            public Course getCurso() {
                return curso;
            }

            public Professor getProfesor() {
                return profesor;
            }



            public void setId(Long id) {
                this.id = id;
            }

            public Long getId() {
                return this.id;
            }

            @Override
            public String toString() {
                return ""+this.profesor+""+this.curso;
            }
        }
