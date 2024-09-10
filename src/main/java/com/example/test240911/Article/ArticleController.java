package com.example.test240911.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/article")
@Controller
public class ArticleController {
    private ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model){
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);

        return "article_list";
    }


    @GetMapping("/detail/{id}")
    public String getArticle (Model model, @PathVariable("id") Integer id){
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article",article);

        return "article_detail";
    }

    @GetMapping("/create")
    public String articleCreate(){
        return "article_form";
    }

    @PostMapping("/create")
    public String articleCreate(@RequestParam("title") String title,
                                @RequestParam("content") String content){
        this.articleService.create(title,content);
        return "redirect:/article/list";
    }
}

