package com.inditex.zboost.repository;

import com.inditex.zboost.entity.Product;
import com.inditex.zboost.entity.ProductOrderItem;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository {

    List<String> getProductCategories();

    List<Product> getProductsByCategories(final Optional<List<String>> categories);

    List<ProductOrderItem> getProductOrderItemsFromOrder(final long orderId);

    Map<String, Integer> getTotalProductsByCategory();
}
