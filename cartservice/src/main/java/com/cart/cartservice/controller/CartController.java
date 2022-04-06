package com.cart.cartservice.controller;

import java.util.List;

import com.cart.cartservice.entity.Product;
import com.cart.cartservice.repository.ProductRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final ProductRepository productRepository;

    @GetMapping("/getProducts")
    public List<Product> getCartProduct() {
        return productRepository.findAll();
    }

    @DeleteMapping("/deleteOne/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteProducts(@PathVariable Long id) {
        productRepository.deleteAll();
    }

    @GetMapping("/info")
    public String gtInfo() {
        return "cart micro-service";
    }
}
