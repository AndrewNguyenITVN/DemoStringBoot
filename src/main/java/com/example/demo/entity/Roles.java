package com.example.demo.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity(name = "role")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "eole_name")
    private String roleNme;

    @OneToMany(mappedBy = "role")
    private List<Users> UserList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleNme() {
        return roleNme;
    }

    public void setRoleNme(String roleNme) {
        this.roleNme = roleNme;
    }

    public List<Users> getUserList() {
        return UserList;
    }

    public void setUserList(List<Users> userList) {
        UserList = userList;
    }
}
