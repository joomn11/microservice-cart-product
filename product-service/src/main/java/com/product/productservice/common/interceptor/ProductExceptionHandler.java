package com.product.productservice.common.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

//@ControllerAdvice(annotations = {RestController.class})
//@ControllerAdvice(assignableTypes = {AbstractController.class})
@ControllerAdvice(basePackages = {"com.cart.cartservice.controller"})
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<?> handleNoSuchElementFoundException(NoSuchElementException e, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {

        webRequest.getParameterNames().forEachRemaining(System.out::println);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Object());
    }
}
