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
        name = "documento",
        updatable = false,
        nullable = false,
        unique = true
    )
    private Long documento;


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
        name="nombre",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String nombre;

    @Column(
        name="apellido",
        updatable = true,
        nullable = false,
        unique = false
    )
    private String apellido;


    @OneToOne(
        mappedBy = "usercredentials",
        orphanRemoval = true
    )
    private Student student;


    public UserCredentials(){}
    public UserCredentials(
        Long documento,
        String password,
        String nombre,
        String apellido){
        this.documento = documento;
        this.password = password;
        this.authorities = "ROLE_ALUMNO";
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public Long getDocumento() {
        return this.documento;
    }


    public String getPassword() {
        return this.password;
    }

    public String getAuthorities() {
        return this.authorities;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void addAuthorities(String authorities) {
        this.authorities += ","+authorities;
    }




}
