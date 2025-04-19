package com.example.demo.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "role_name")
    private String roleNme;

    @Column(name = "create_date")
    private Date createDate;

    public Set<Users> getListUser() {
        return ListUser;
    }

    public void setListUser(Set<Users> listUser) {
        ListUser = listUser;
    }

    @OneToMany(mappedBy = "role")
    private Set<Users> ListUser;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
