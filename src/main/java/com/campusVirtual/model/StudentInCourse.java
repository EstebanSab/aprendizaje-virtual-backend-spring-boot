package com.campusVirtual.model;

import javax.persistence.*;



import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
@Entity(name="StudentInCourse")
@Table(
    name="student_in_course",
    uniqueConstraints = {
        @UniqueConstraint(
            name="studentInCourse_id_constraint",columnNames = "id"
        )
    }
)
public class StudentInCourse {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
        )
        private Long id;


        @ManyToOne()
        @JoinColumn(
            name="student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = 
                @ForeignKey(name="student_course_id")
            
        )
        private Student student;


        @ManyToOne()
        @JoinColumn(
            name="course_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = 
                @ForeignKey(name="cpurse_student_id")
            
        )
        private Course course;


        public StudentInCourse(){}

        public StudentInCourse(Student student,Course course){
            this.student=student;
            this.course=course;
        }
    
}
