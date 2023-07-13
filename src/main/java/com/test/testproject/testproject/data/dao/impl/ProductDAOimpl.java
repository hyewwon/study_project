package com.test.testproject.testproject.data.dao.impl;

import com.test.testproject.testproject.data.dao.ProductDAO;
import com.test.testproject.testproject.data.entity.ProductEntity;
import com.test.testproject.testproject.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOimpl implements ProductDAO {
    ProductRepository productRepository;

    @Autowired
    public ProductDAOimpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity){
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId){
        ProductEntity productEntity = productRepository.getReferenceById(productId);
        return productEntity;
    }
}
