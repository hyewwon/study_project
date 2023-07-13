package com.test.testproject.testproject.data.repository;

import com.test.testproject.testproject.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

                                            //JpaRepository<사용할 entity, entity pk의 type>
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
