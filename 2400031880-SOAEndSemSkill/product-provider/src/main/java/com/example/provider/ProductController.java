package com.example.provider;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Map<Long, Product> products = Map.of(
        101L, new Product(101L, "Laptop", "Business laptop", 55000.0),
        102L, new Product(102L, "Phone", "Android smartphone", 25000.0),
        103L, new Product(103L, "Headphones", "Wireless headphones", 3000.0)
    );

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        Product product = products.get(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found: " + id);
        }
        return product;
    }
}
