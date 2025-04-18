package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "Catetory")
public class Catetory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_cate")
    private String name_cate;

    @Column(name = "create_date")
    private Date createDate;


    @OneToMany(mappedBy = "cateId")
    private Set<Food> ListFood;

    @OneToMany(mappedBy = "cateId")
    private Set<MenuRestaurant> ListMenuRestaurant;

    public Set<MenuRestaurant> getListMenuRestaurant() {
        return ListMenuRestaurant;
    }

    public void setListMenuRestaurant(Set<MenuRestaurant> listMenuRestaurant) {
        ListMenuRestaurant = listMenuRestaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_cate() {
        return name_cate;
    }

    public void setName_cate(String name_cate) {
        this.name_cate = name_cate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<Food> getListFood() {
        return ListFood;
    }

    public void setListFood(Set<Food> listFood) {
        ListFood = listFood;
    }
}
