package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "is_freeship")
    private boolean isFreeship;

    @Column(name = "address")
    private String address;

    @Column(name = "open_date")
    private Date openDate;

    @OneToMany(mappedBy = "resId")
    private Set<RatingRestaurant> ListRatingRestaurant;

    @OneToMany(mappedBy = "resId")
    private Set<Orders> ListOrders;

    @OneToMany(mappedBy = "resId")
    private Set<MenuRestaurant> ListMenuRestaurant;

    @OneToMany(mappedBy = "resId")
    private Set<Promo> ListPromo;

    public Set<Promo> getListPromo() {
        return ListPromo;
    }

    public void setListPromo(Set<Promo> listPromo) {
        ListPromo = listPromo;
    }

    public Set<MenuRestaurant> getListMenuRestaurant() {
        return ListMenuRestaurant;
    }

    public void setListMenuRestaurant(Set<MenuRestaurant> listMenuRestaurant) {
        ListMenuRestaurant = listMenuRestaurant;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Set<RatingRestaurant> getListRatingRestaurant() {
        return ListRatingRestaurant;
    }

    public void setListRatingRestaurant(Set<RatingRestaurant> listRatingRestaurant) {
        ListRatingRestaurant = listRatingRestaurant;
    }
}
