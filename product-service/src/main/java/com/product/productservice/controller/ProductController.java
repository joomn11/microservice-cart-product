package com.product.productservice.controller;

import java.util.List;

import com.product.productservice.entity.Product;
import com.product.productservice.repository.ProductRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping("/addOne")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PostMapping("/addList")
    public List<Product> addProductList(@RequestBody List<Product> products) {
        return productRepository.saveAll(products);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
