package com.campusVirtual.model;

import javax.persistence.*;


@Entity(name = "UserCredentials")
@Table(
    name="usercredentials",
    uniqueConstraints = {
        @UniqueConstraint(name="user_dni_constraint",columnNames = "documento")
    })
public class UserCredentials {
    @Id
    @Column(
        name = "document",
        updatable = false,
        nullable = false,
        unique = true
    )
    private Long document;


    @Column(
        name="password",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String password;


    @Column(
        name="authorities",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String authorities = "ROLE_ALUMNO";

    @Column(
        name="name",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String name;

    @Column(
        name="lastname",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String lastName;


    @OneToOne(
        mappedBy = "usercredentials",
        orphanRemoval = true
    )
    private Student student;

    @OneToOne(
        mappedBy = "usercredentials",
        orphanRemoval = true
    )
    private Professor professor;


    public UserCredentials(){}
    public UserCredentials(
        Long document,
        String password,
        String name,
        String lastName){
        this.document = document;
        this.password = password;
        this.authorities = "ROLE_ALUMNO";
        this.name = name;
        this.lastName = lastName;
    }


    public Long getDocument() {
        return this.document;
    }


    public String getPassword() {
        return this.password;
    }

    public String getAuthorities() {
        return this.authorities;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return lastName;
    }

    public Student getStudent() {
        return this.student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addAuthorities(String authorities) {
        this.authorities += ","+authorities;
    }




}
