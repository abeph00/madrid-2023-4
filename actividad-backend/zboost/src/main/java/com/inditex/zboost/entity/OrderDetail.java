package com.inditex.zboost.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderDetail extends Order implements Serializable {

    private Double totalPrice;

    private Integer itemsCount;

    private List<ProductOrderItem> products;

    public List<ProductOrderItem> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrderItem> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail orderDetail = (OrderDetail) o;
        return super.equals(o) && totalPrice.equals(orderDetail.totalPrice) && itemsCount.equals(orderDetail.itemsCount)
                && products.equals(orderDetail.products);
    }
}
