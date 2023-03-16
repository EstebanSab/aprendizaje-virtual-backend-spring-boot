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
            name="userdata_document",
            referencedColumnName = "document",
            foreignKey = @ForeignKey(
                name = "user_id_fk"
            )
        )
        private Userdata user;
        
        public Student(){}
        
        public void setId(Long id) {
            this.id = id;
        }
        
    
       public void setUser(Userdata user) {
           this.user = user;
       }

      

        public void addStudentInCourse(StudentInCourse studentInCourse) {
            if (!this.studentInCourse.contains(studentInCourse)) {
                this.studentInCourse.add(studentInCourse);
            }
        }


        public Long getId() {
            return this.id;
        }

        public Userdata getUser() {
            return this.user;
        }
        public List<StudentInCourse> getStudentInCourse() {
            return studentInCourse;
        }

        @Override
        public String toString() {
            return "Student id: "+this.id;
        }
      
}
