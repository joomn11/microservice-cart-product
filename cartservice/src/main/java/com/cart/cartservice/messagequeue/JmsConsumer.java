package com.cart.cartservice.messagequeue;

import com.cart.cartservice.entity.Product;
import com.cart.cartservice.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JmsConsumer {

    private final ProductRepository productRepository;
    private final ObjectMapper mapper;

    @JmsListener(destination = "${product.jms.destination}")
    public void consumeMessage(String data) {
        try {
            Product product = mapper.readValue(data, Product.class);

            log.info("data: {}", data);
            productRepository.save(product);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
