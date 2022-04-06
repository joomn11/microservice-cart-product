package com.product.productservice.controller;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.productservice.entity.Product;
import com.product.productservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final JmsTemplate jmsTemplate;
    private final ObjectMapper mapper;

    // get value from yaml file
    @Value("${product.jms.destination}")
    private String jmsQueue;

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

    @GetMapping("/sendToCart/{id}")
    public ResponseEntity<Product> sendToCart(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            String jsonInString = mapper.writeValueAsString(product.get());

            jmsTemplate.convertAndSend(jmsQueue, jsonInString);

            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
