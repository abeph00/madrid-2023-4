package com.inditex.zboost.utils;

import com.inditex.zboost.entity.Product;
import com.inditex.zboost.entity.ProductOrderItem;
import com.inditex.zboost.entity.ProductRank;

public class Converters {

    public static ProductRank toProductRank(ProductOrderItem productOrderItem) {
        ProductRank productRank = new ProductRank();
        productRank.setId(productOrderItem.getId());
        productRank.setName(productOrderItem.getName());
        productRank.setCategory(productOrderItem.getCategory());
        productRank.setPrice(productOrderItem.getPrice());
        productRank.setImageUrl(productOrderItem.getImageUrl());
        productRank.setPrice(productOrderItem.getPrice());
        return productRank;
    }

    public static Product toProduct(ProductOrderItem productOrderItem) {
        Product product = new Product();
        product.setId(productOrderItem.getId());
        product.setName(productOrderItem.getName());
        product.setCategory(productOrderItem.getCategory());
        product.setPrice(productOrderItem.getPrice());
        product.setImageUrl(productOrderItem.getImageUrl());
        return product;
    }
}
