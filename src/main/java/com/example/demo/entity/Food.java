package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tital")
    private String title;

    @Column(name = "image")
    private  String image;

    @Column(name = "time_ship")
    private String timeShip;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Catetory cateId;

    @OneToMany(mappedBy = "foodId")
    private Set<RatingFood> ListRatingFood;

    @OneToMany(mappedBy = "foodId")
    private Set<OrderItem> ListOrderItem;

    public Set<OrderItem> getListOrderItem() {
        return ListOrderItem;
    }

    public void setListOrderItem(Set<OrderItem> listOrderItem) {
        ListOrderItem = listOrderItem;
    }

    public Set<RatingFood> getListRatingFood() {
        return ListRatingFood;
    }

    public void setListRatingFood(Set<RatingFood> listRatingFood) {
        ListRatingFood = listRatingFood;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Catetory getCateId() {
        return cateId;
    }

    public void setCateId(Catetory cateId) {
        this.cateId = cateId;
    }
}
