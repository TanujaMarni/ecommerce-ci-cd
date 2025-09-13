package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private final Map<Long, Product> products = new HashMap<>();
    private long counter = 1;

    // constructor with defaults (for production)
    public ProductService() {
        this(true);
    }

    // constructor with option to disable defaults (for tests)
    public ProductService(boolean withDefaults) {
        if (withDefaults) {
            add(new Product(null, "Laptop", 750.00, "/images/laptop.jpg"));
            add(new Product(null, "Smartphone", 500.00, "/images/iphone.jpg"));
            add(new Product(null, "Headphones", 120.00, "/images/product3.jpg"));
        }
    }

    // list all products
    public List<Product> listAll() {
        return new ArrayList<>(products.values());
    }

    // find by id
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    // add new product
    public Product add(Product p) {
        if (p.getId() == null) {
            p = new Product(counter++, p.getName(), p.getPrice(), p.getImageUrl());
        }
        products.put(p.getId(), p);
        return p;
    }

    // alias for clarity (used in tests)
    public void addProduct(Product p) {
        add(p);
    }
}
