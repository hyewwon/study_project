package com.test.testproject.testproject.controller;

import com.test.testproject.testproject.data.dto.AddArticleDto;
import com.test.testproject.testproject.data.entity.ArticleEntity;
import com.test.testproject.testproject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/create")
    public ResponseEntity<ArticleEntity> createArticle(@RequestBody AddArticleDto addArticleDto){
        ArticleEntity savedArticle = articleService.saveArticle(addArticleDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
}
