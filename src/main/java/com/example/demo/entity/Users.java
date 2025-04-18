package com.example.demo.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private  String fullName;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

    @OneToMany(mappedBy = "userId")
    private Set<RatingFood> ListRatingFood;

    public Set<RatingFood> getListRatingFood() {
        return ListRatingFood;
    }

    public void setListRatingFood(Set<RatingFood> listRatingFood) {
        ListRatingFood = listRatingFood;
    }

    @OneToMany(mappedBy = "userId")
    private Set<RatingRestaurant> ListRatingRestaurant;

    public Set<RatingRestaurant> getListRatingRestaurant() {
        return ListRatingRestaurant;
    }

    public void setListRatingRestaurant(Set<RatingRestaurant> listRatingRestaurant) {
        ListRatingRestaurant = listRatingRestaurant;
    }

    @OneToMany(mappedBy = "userId")
    private Set<Orders> ListOrders;

    public Set<Orders> getListOrders() {
        return ListOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        ListOrders = listOrders;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
