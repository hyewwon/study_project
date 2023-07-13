package com.test.testproject.testproject.data.dao;

import com.test.testproject.testproject.data.entity.ProductEntity;

public interface ProductDAO {
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
