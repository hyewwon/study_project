package com.test.testproject.testproject.service;

import com.test.testproject.testproject.data.dto.AddArticleDto;
import com.test.testproject.testproject.data.entity.ArticleEntity;

public interface ArticleService {
    ArticleEntity saveArticle(AddArticleDto addArticleDto);
}
