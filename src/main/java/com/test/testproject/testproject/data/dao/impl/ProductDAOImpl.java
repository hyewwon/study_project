package com.test.testproject.testproject.data.dao.impl;

import com.test.testproject.testproject.data.dao.ProductDAO;
import com.test.testproject.testproject.data.entity.ProductEntity;
import com.test.testproject.testproject.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {
    ProductRepository productRepository;

    @Autowired // 객체 주입 (DI : 의존성 주입) --> 필요할 때마다 새롭게 객체를 생성해서 사용하는 것이 아닌 미리 객체 하나를 빈으로 설정하여 여러 곳에 주입(싱글톤)
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity){
        productRepository.save(productEntity); // 데이터를 저장하는 메소드
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId){
        ProductEntity productEntity = productRepository.getReferenceById(productId); // id를 기반으로 가져오는 메소드
        return productEntity;
    }
    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        ProductEntity product = productRepository.getReferenceById(productEntity.getProductId());
        product.setProductName(productEntity.getProductName());
        product.setProductPrice(productEntity.getProductPrice());
        product.setProductStock(productEntity.getProductStock());
        productRepository.save(product);
        return product;
    }

}
