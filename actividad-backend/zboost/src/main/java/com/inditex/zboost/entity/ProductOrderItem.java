package com.inditex.zboost.entity;

import java.io.Serializable;

public class ProductOrderItem extends Product implements Serializable {

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductOrderItem productOrderItem = (ProductOrderItem) o;
        return super.equals(o) && quantity == productOrderItem.quantity;
    }
}
