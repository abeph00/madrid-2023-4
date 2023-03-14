package com.inditex.zboost.service;

import com.inditex.zboost.entity.Product;
import com.inditex.zboost.repository.ProductRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<String> findProductCategories() {
        return this.productRepository.getProductCategories();
    }

    @Override
    public List<Product> findProducts(Optional<List<String>> categories) {
        return this.productRepository.getProductsByCategories(categories);
    }

}
