package com.test.testproject.testproject.controller;

import com.test.testproject.testproject.data.dto.ProductDto;
import com.test.testproject.testproject.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId){
        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] {} API", "getProduct");
        ProductDto productDto = productService.getProduct(productId);
        LOGGER.info("[ProductController] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}", // logger의 내장된 기능 : {}를 사용하여 원하는 값을 string 안에 넣기 가능
                productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(), (System.currentTimeMillis() - startTime));
        return productDto;
    }

    @PostMapping(value = "/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    @PutMapping(value = "/product/edit/{productId}")
    public ProductDto editProduct(@RequestBody ProductDto productDto, @PathVariable String productId){
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.editProduct(productId, productName, productPrice, productStock);
    }


    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId){
        return null;
    }


}
