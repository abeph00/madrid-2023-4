package com.inditex.zboost.controller;

import com.inditex.zboost.entity.Product;
import com.inditex.zboost.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(name = "category", required = false) List<String> categories) {
        return productService.findProducts(Optional.ofNullable(categories));
    }

    @GetMapping("/products/categories")
    public List<String> getProductsCategories() {
        return productService.findProductCategories();
    }
}
