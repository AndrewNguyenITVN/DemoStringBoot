package com.example.demo.entity;

import com.example.demo.entity.keys.keyMenuRestaurant;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "menu_restaurant")
public class MenuRestaurant {

    @EmbeddedId
    keyMenuRestaurant key;

    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false, updatable = false)
    private Catetory cateId;

    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant resId;

    @Column(name = "create_date")
    private Date createDate;

    public keyMenuRestaurant getKey() {
        return key;
    }

    public void setKey(keyMenuRestaurant key) {
        this.key = key;
    }

    public Catetory getCateId() {
        return cateId;
    }

    public void setCateId(Catetory cateId) {
        this.cateId = cateId;
    }

    public Restaurant getResId() {
        return resId;
    }

    public void setResId(Restaurant resId) {
        this.resId = resId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
