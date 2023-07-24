package com.test.testproject.testproject.service.impl;

import com.test.testproject.testproject.data.dto.AddArticleDto;
import com.test.testproject.testproject.data.entity.ArticleEntity;
import com.test.testproject.testproject.data.repository.ArticleRepository;
import com.test.testproject.testproject.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public ArticleEntity saveArticle(AddArticleDto addArticleDto) {
        return articleRepository.save(addArticleDto.toEntity());
    }
}
