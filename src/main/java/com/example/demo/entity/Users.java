package com.example.demo.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private  String fullName;

    @Column(name = "age")
    private int age;

    @Column(name = "username")
    private String username;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "created_date")
    private Date created_date;

//    @Column(name = "role_id")
//    private int roleId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
