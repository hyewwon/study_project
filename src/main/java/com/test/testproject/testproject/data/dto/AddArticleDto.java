package com.test.testproject.testproject.data.dto;

import com.test.testproject.testproject.data.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleDto {
    private String title;
    private String content;

    public ArticleEntity toEntity(){
        return ArticleEntity.builder()
                .title(title)
                .content(content)
                .build();
    }
}
