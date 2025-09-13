package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService svc;

    @BeforeEach
    void setup() {
        svc = new ProductService(false); // no defaults in tests
    }

    @Test
    void testAddProduct() {
        Product p = new Product(null, "Laptop", 50000.0, "/images/laptop.jpg");
        svc.addProduct(p);

        List<Product> products = svc.listAll();
        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getName());
    }

    @Test
    void testListAll() {
        svc.addProduct(new Product(null, "Phone", 20000.0, "/images/iphone.jpg"));
        svc.addProduct(new Product(null, "Tablet", 30000.0, "/images/tablet.jpg"));

        List<Product> products = svc.listAll();
        assertEquals(2, products.size());
    }
}
