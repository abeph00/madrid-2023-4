package com.inditex.zboost.entity;

import java.io.Serializable;
import java.util.Map;

public class ReportSummary implements Serializable {

    private Integer totalProducts;
    private Integer totalOrders;
    private Double totalSales;

    private Map<String, Integer> totalProductsByCategory;
    
    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Integer getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public Map<String, Integer> getTotalProductsByCategory() {
        return totalProductsByCategory;
    }

    public void setTotalProductsByCategory(Map<String, Integer> totalProductsByCategory) {
        this.totalProductsByCategory = totalProductsByCategory;
    }
}
