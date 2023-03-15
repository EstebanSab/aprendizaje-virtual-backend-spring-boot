package com.campusVirtual.model;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity(name="Course")
@Table(
    name="course",
    uniqueConstraints = {
        @UniqueConstraint(name="course_id_constraint",columnNames = "id")
    }
)
public class Course {
    @Id
    @SequenceGenerator(
        name = "generadoIdCourse",
        sequenceName = "COURSE_GENERADOR_ID",
        initialValue=1,
        allocationSize = 1
    )
    @GeneratedValue(
        generator = "generadoIdCourse",
        strategy = GenerationType.SEQUENCE)
    @Column(
        name = "id",
        updatable = false,
        nullable = false,
        unique = true
    )
    private Long id;

    @Column(
        name = "name",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String name;

    
    @OneToMany(
        mappedBy = "course",
        orphanRemoval = true,
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
        //,fetch = FetchType.EAGER
        )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProfessorInCourse> professorInCourse = new ArrayList<ProfessorInCourse>();
    //private Ensenia ensenia;


    @OneToMany(
            mappedBy = "course",
            orphanRemoval = true,
            cascade ={CascadeType.PERSIST,CascadeType.REMOVE}
            //fetch = FetchType.EAGER
        )
        @OnDelete(action = OnDeleteAction.CASCADE)
        @LazyCollection(LazyCollectionOption.FALSE)
        private List<StudentInCourse> studentInCourse = new ArrayList<StudentInCourse>();
        
    
       

    public Course(){}
    public Course(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public List<ProfessorInCourse> getProfessorInCourse() {
        return this.professorInCourse;
    }

    public List<StudentInCourse> getStudentInCourse() {
        return this.studentInCourse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProfessorInCourse(ProfessorInCourse professorInCourse) {
        if (!this.professorInCourse.contains(professorInCourse)) {
            this.professorInCourse.add(professorInCourse);
        }
    }

    public void addAlumnoEnCurso(StudentInCourse studentInCourse) {
        if (!this.studentInCourse.contains(studentInCourse)) {
            this.studentInCourse.add(studentInCourse);
        }
    }

    /*public void removeProfesorEnCurso(ProfesorEnCurso profesorEnCurso) {
        if (this.profesorEnCurso.contains(profesorEnCurso)) {
            this.profesorEnCurso.remove(profesorEnCurso);
        }
    }*/
   


    

    
    
}
