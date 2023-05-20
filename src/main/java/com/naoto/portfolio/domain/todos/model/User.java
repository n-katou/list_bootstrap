package com.naoto.portfolio.domain.todos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;



@Data
@Entity
@Table(name= "user")

public class User {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max=255)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max=255)
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(max=10)
    @Column(name = "role")
    private String role;

    public User(){

    }

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

}

