package com.HY.productservice.service;

import com.HY.productservice.dto.ProductRequest;
import com.HY.productservice.dto.ProductResponse;
import com.HY.productservice.model.Product;
import com.HY.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    //the following constructor statement can be replaced with lombok @RequiredArgsConstructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest){

        //first map the productrequest to the product model
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        //after create instance of the product object, we need to save it into database
        //need to access the ProductRepository, so inject product repository into this class

        productRepository.save(product);
        log.info("Product " + product.getId() + " is saved");
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
