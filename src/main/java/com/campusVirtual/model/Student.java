package com.campusVirtual.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity(name="Student")
@Table(
    name="student",
    uniqueConstraints = {
        @UniqueConstraint(name="student_id_constraint",columnNames = "id")
    }
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "generadoIdStudent",
            sequenceName = "STUDENT_GENERADOR_ID",
            initialValue=1,
            allocationSize = 1
        )
        @GeneratedValue(
            generator = "generadoIdStudent",
            strategy = GenerationType.SEQUENCE)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;


        @OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade ={CascadeType.PERSIST,CascadeType.REMOVE}
            //fetch = //FetchType.EAGER
        )
        @OnDelete(action = OnDeleteAction.CASCADE)
        @LazyCollection(LazyCollectionOption.FALSE)
        private List<StudentInCourse> studentInCourse = new ArrayList<StudentInCourse>();
        

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(
            name="user_id",
            referencedColumnName = "document",
            foreignKey = @ForeignKey(
                name = "user_id_fk"
            )
        )
        private UserCredentials userCredentials;
    
        public Student(){}
        
        public void setId(Long id) {
            this.id = id;
        }
        
    
        
        public void setUserCredentials(UserCredentials userCredentials) {
            this.userCredentials = userCredentials;
        }

        public void addStudentInCourse(StudentInCourse studentInCourse) {
            if (!this.studentInCourse.contains(studentInCourse)) {
                this.studentInCourse.add(studentInCourse);
            }
        }


        public Long getId() {
            return this.id;
        }

        public UserCredentials getUserCredentials() {
            return this.userCredentials;
        }

        public List<StudentInCourse> getStudentInCourse() {
            return studentInCourse;
        }

      
}
