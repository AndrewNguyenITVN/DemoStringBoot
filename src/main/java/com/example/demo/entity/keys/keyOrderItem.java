package com.example.demo.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class keyOrderItem implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "food_id")
    private int foodId;

    public keyOrderItem(){}

    public keyOrderItem(int orderId, int foodId){
        this.orderId = orderId;
        this.foodId = foodId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
