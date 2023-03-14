package com.inditex.zboost.service;

import com.inditex.zboost.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findProducts(Optional<List<String>> categories);

    List<String> findProductCategories();
}
