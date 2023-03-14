package com.inditex.zboost.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The type Order.
 */
public class Order implements Serializable {
    private long id;
    private Date date;
    private String status;

    public Order() {
        // empty constructor
    }

    public Order(long id, Date date, String status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && date.equals(order.date) && status.equals(order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
