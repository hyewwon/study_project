package com.test.testproject.testproject.controller;

import com.test.testproject.testproject.common.Constants;
import com.test.testproject.testproject.common.exception.TestProjectException;
import com.test.testproject.testproject.data.dto.ProductDto;
import com.test.testproject.testproject.service.ProductService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.bcel.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto){
        // @Valid 어노테이션을 붙어셔 DTO에 사용했던 Validation이 동작되도록 함
            // * @Valid 자바 표준 검증 어노테이션 / @Validated  스프링 전용 검증 어노테이션
        // 직접 코드 구현 Validation
//        if(productDto.getProductId().equals("") || productDto.getProductId().isEmpty()){
//            LOGGER.error("[createProduct] faild Response :: productId is Empty");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST.body(productDto));
//        }
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

    @PostMapping(value = "/product/exception")
    public void exceptionTest() throws TestProjectException{
        throw new TestProjectException(Constants.ExceptionClass.PRODUCT, HttpStatus.BAD_REQUEST, "의도한 에러가 발생");
    }

}
