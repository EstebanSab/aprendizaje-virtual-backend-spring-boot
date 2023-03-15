package com.campusVirtual.model;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name="Profesor")
@Table(
    name="profesor",
    uniqueConstraints = {
        @UniqueConstraint(name="professor_id_constraint",columnNames = "id")
    }
)
public class Professor {

        @Id
        @SequenceGenerator(
            name = "generadoIdProfessor",
            sequenceName = "PROFESSOR_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdProfessor",
            strategy = GenerationType.SEQUENCE)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;


        @Column(
            name="especiality",
            updatable =true,
            nullable = false,
            unique = false
        )
        private String especiality;


        @OneToMany(
            mappedBy = "professor",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
            //,fetch = FetchType.EAGER
            )
            @OnDelete(action = OnDeleteAction.CASCADE)
            @LazyCollection(LazyCollectionOption.FALSE)
        private List<ProfessorInCourse> professorInCourse = new ArrayList<ProfessorInCourse>();
        
    
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(
            name="user_id",
            referencedColumnName = "document",
            foreignKey = @ForeignKey(
                name = "user_id_fk"
            )
        )
        private UserCredentials userCredentials;
    


    
        public Professor(){}
        public Professor(String especiality){
            this.especiality=especiality;
        }
    
        public Long getId() {
            return this.id;
        }
        
        public String getEspeciality() {
            return this.especiality;
        }
        
        public List<ProfessorInCourse> getProfessorInCourse() {
            return professorInCourse;
        }

        public void setId(Long id) {
            this.id = id;
        }
    
        public void setEspeciality(String especiality) {
            this.especiality = especiality;
        }

        public void addProfessorInCourse(ProfessorInCourse professorInCourse) {
            if (!this.professorInCourse.contains(professorInCourse)) {
                this.professorInCourse.add(professorInCourse);
            }
        }


        public void setUserCredentials(UserCredentials userCredentials) {
            this.userCredentials = userCredentials;
        }

        public UserCredentials getUserCredentials() {
            return userCredentials;
        }
        
    }
