package com.campusVirtual.model;

import javax.persistence.*;


@Entity(name = "Userdata")
@Table(
    name="userdata",
    uniqueConstraints = {
        @UniqueConstraint(name="user_dni_constraint",columnNames = "document")
    })
public class Userdata {
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
        name="mail",
        updatable = true,
        nullable = false,
        unique = true
    )
    private String mail;


    @Column(
        name="authorities",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String authorities = "ROLE_STUDENT";

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
        mappedBy = "user",
        orphanRemoval = true
    )
    private Student student;

    @OneToOne(
        mappedBy = "user",
        orphanRemoval = true
    )
    private Professor professor;

    public Userdata(){}
    public Userdata(
        Long document,
        String password,
        String name,
        String lastName,
        String mail){
        this.document = document;
        this.password = password;
        this.authorities = "ROLE_STUDENT";
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
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

    public String getMail() {
        return mail;
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
