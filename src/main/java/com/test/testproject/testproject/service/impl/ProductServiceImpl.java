package com.test.testproject.testproject.service.impl;

import com.test.testproject.testproject.data.dto.ProductDto;
import com.test.testproject.testproject.data.entity.ProductEntity;
import com.test.testproject.testproject.data.handler.ProductDataHandler;
import com.test.testproject.testproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler){
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);
        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());
        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);
        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }

    @Override
    public ProductDto editProduct(String productId, String productName, int productPrice, int productStock) {
        return null;
    }


}
