package com.example.test240911;

import com.example.test240911.Article.Article;
import com.example.test240911.Article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Test240911ApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;

	@Test // 테스트용 게시물 생성
	void contextLoads() {
		Article article = new Article();
		article.setTitle("테스트용");
		article.setContent("지문입니다람쥐");

		article.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(article);

	}
}
