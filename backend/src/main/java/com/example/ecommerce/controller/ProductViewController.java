package com.example.ecommerce.controller;

import com.example.ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductViewController {
    private final ProductService svc;

    public ProductViewController(ProductService svc) {
        this.svc = svc;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", svc.listAll());
        return "products"; // looks for templates/products.html
    }
}
