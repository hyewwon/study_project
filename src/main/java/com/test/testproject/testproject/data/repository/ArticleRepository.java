package com.test.testproject.testproject.data.repository;

import com.test.testproject.testproject.data.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
