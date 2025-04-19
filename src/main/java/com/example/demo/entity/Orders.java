package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;

    @ManyToOne
    @JoinColumn(name = "res_id")
    private Restaurant resId;

    @OneToMany(mappedBy = "orderId")
    private Set<OrderItem> ListOrderItem;

    public Set<OrderItem> getListOrderItem() {
        return ListOrderItem;
    }

    public void setListOrderItem(Set<OrderItem> listOrderItem) {
        ListOrderItem = listOrderItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Restaurant getResId() {
        return resId;
    }

    public void setResId(Restaurant resId) {
        this.resId = resId;
    }
}
