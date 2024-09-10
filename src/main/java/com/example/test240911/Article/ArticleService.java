package com.example.test240911.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList(){
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id){
        Optional<Article> optionalArticle= this.articleRepository.findById(id);
        if(optionalArticle.isEmpty()){
            return null;
        }else {
            return optionalArticle.get();
        }
    }

    public void create (String title, String content){
        Article a = new Article();
        a.setTitle(title);
        a.setContent(content);
        a.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(a);
    }
}
