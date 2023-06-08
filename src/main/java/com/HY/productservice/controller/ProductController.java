package com.HY.productservice.controller;

import com.HY.productservice.dto.ProductRequest;
import com.HY.productservice.dto.ProductResponse;
import com.HY.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor //used to constructor injection
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //HttpStatus.CREATED: 201, and expect the response status to be created
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK) // HttpStatus.OK: 200
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}
