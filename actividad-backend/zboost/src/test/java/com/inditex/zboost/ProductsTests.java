package com.inditex.zboost;

import com.inditex.zboost.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * The type Orders tests.
 */
@SpringBootTest(classes = ZboostApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
class ProductsTests {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    void givenAProductCatalog_whenRetrievingProductsWithoutFilteringCategory_thenFullCatalogShouldBeReturned() {
        assertDoesNotThrow(() -> {
            Product[] object = getProducts(List.of());

            Map<String, List<Product>> map =
                Arrays.stream(object).collect(Collectors.groupingBy(Product::getCategory, Collectors.toList()));
            assertEquals(9, object.length);
            assertEquals(4, map.size());
            assertEquals(3, map.get("Pants").size());
            assertEquals(1, map.get("Dresses").size());
            assertEquals(2, map.get("Jackets").size());
            assertEquals(3, map.get("Sweaters").size());
        });
    }

    @Test
    void givenAProductCatalog_whenRetrievingProductsFilteringByCategory_thenCategoryProductsShouldBeReturned() {
        assertDoesNotThrow(() -> {
            Product[] object = getProducts(List.of("Pants"));
            verifyProducts(object, List.of("Pant A", "Pant B", "Pant C"), 3);

            Product[] object2 = getProducts(List.of("dREssEs"));
            verifyProducts(object2, List.of("Dress A"), 1);

            Product[] object3 = getProducts(List.of("jackets"));
            verifyProducts(object3, List.of("Jacket A", "Jacket B"), 2);
        });
    }

    @Test
    void givenAProductCatalog_whenRetrievingAvailableCategories_thenAllOfThemShouldBeReturned() {
        assertDoesNotThrow(() -> {
            String[] productsCategories = getProductsCategories();

            assertEquals(4, productsCategories.length);
            assertTrue(Arrays.asList(productsCategories).containsAll(List.of("Pants", "Dresses", "Jackets", "Sweaters")));
        });
    }

    private Product[] getProducts(List<String> categories) {
        List<String> qsParts = new ArrayList<>();
        if (!categories.isEmpty()) {
            categories
                    .stream()
                    .forEach(cat -> qsParts.add("category=" + cat));
        }

        return this.testRestTemplate
                .getForObject(getHostPort() + "/products" + (qsParts.isEmpty() ? "" : "?" + String.join("&", qsParts)), Product[].class, Map.of());
    }

    private String[] getProductsCategories() {
        return this.testRestTemplate
                .getForObject(getHostPort() + "/products/categories", String[].class, Map.of());
    }

    private void verifyProducts(Product[] products, Collection<String> namesToFind, int expectedNumberOfResults) {
        assertEquals(expectedNumberOfResults, products.length);

        namesToFind
                .forEach(name -> assertTrue(Arrays.stream(products).anyMatch(p -> name.equals(p.getName()))));
    }

    private String getHostPort() {
        return "http://localhost:" + this.port;
    }

}
