package com.campusVirtual.model;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity(name="Curso")
@Table(
    name="curso",
    uniqueConstraints = {
        @UniqueConstraint(name="cliente_id_constraint",columnNames = "id")
    }
)
public class Course {
    @Id
    @SequenceGenerator(
        name = "generadoIdCurso",
        sequenceName = "CURSO_GENERADOR_ID",
        initialValue=1,
        allocationSize = 1
    )
    @GeneratedValue(
        generator = "generadoIdCurso",
        strategy = GenerationType.SEQUENCE)
    @Column(
        name = "id",
        updatable = false,
        nullable = false,
        unique = true
    )
    private Long id;

    @Column(
        name = "nombre",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String nombre;

    
    @OneToMany(
        mappedBy = "curso",
        orphanRemoval = true,
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
        //,fetch = FetchType.EAGER
        )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProfessorInCourse> profesorEnCurso = new ArrayList<ProfessorInCourse>();
    //private Ensenia ensenia;

   
    public void addProfesorEnCurso(ProfessorInCourse profesorEnCurso) {
        if (!this.profesorEnCurso.contains(profesorEnCurso)) {
            this.profesorEnCurso.add(profesorEnCurso);
        }
    }
    /*public void removeProfesorEnCurso(ProfesorEnCurso profesorEnCurso) {
        if (this.profesorEnCurso.contains(profesorEnCurso)) {
            this.profesorEnCurso.remove(profesorEnCurso);
        }
    }*/


    @OneToMany(
            mappedBy = "curso",
            orphanRemoval = true,
            cascade ={CascadeType.PERSIST,CascadeType.REMOVE}
            //fetch = FetchType.EAGER
        )
        @OnDelete(action = OnDeleteAction.CASCADE)
        @LazyCollection(LazyCollectionOption.FALSE)
        private List<StudentInCourse> alumnoEnCurso = new ArrayList<StudentInCourse>();
        
    
        public void addAlumnoEnCurso(StudentInCourse alumnoEnCurso) {
            if (!this.alumnoEnCurso.contains(alumnoEnCurso)) {
                this.alumnoEnCurso.add(alumnoEnCurso);
            }
        }

    public Course(){}
    public Course(String nombre){
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<StudentInCourse> getAlumnoEnCurso() {
        return alumnoEnCurso;
    }

    public List<ProfessorInCourse> getProfesorEnCurso() {
        return profesorEnCurso;
    }

    
    @Override
    public String toString() {
        return "curso: "+this.nombre;
    }

    
    
}
