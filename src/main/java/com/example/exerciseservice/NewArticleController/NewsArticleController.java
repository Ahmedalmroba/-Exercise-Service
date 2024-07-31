package com.example.exerciseservice.NewArticleController;
import com.example.exerciseservice.NewsArticle.NewArticle;
import com.example.exerciseservice.NewsArticleService.NewsArticleService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class NewsArticleController {

    private final NewsArticleService newsArticleService;


    @GetMapping("/get")
    public ResponseEntity getNewsArticle(){
        ArrayList<NewArticle> NewArticles =newsArticleService.getAllNewsArticles();
        return ResponseEntity.status(200).body(NewArticles);


    }
    @PostMapping("add")
    public ResponseEntity addNewsArticle(@Valid @RequestBody NewArticle newArticle, Errors errors) {
        if (errors.hasErrors()) {
            String maseege = errors.getFieldErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(maseege);
        }
        newsArticleService.addNewArticle(newArticle);
        return ResponseEntity.status(200).body(newArticle);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlag(@PathVariable int id ,@Valid@RequestBody NewArticle newArticle, Errors errors) {
        if (errors.hasErrors()) {
            String maseege = errors.getFieldErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(maseege);

        }
        boolean isUpdated = newsArticleService.updateNewArticle(id,newArticle);
        if(isUpdated){
            return ResponseEntity.status(200).body("Successfully updated");
        }
        return ResponseEntity.status(400).body("Error updating");
    }
     @DeleteMapping("/delete/{id}")
      public ResponseEntity DeleteArticle(@PathVariable int id) {
        boolean isDeleted = newsArticleService.deleteNewArticle(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Successfully deleted");
        }
        return ResponseEntity.status(400).body("Error deleting");

    }
      @PutMapping("/publish/{id}")
      public ResponseEntity publishArticle(@PathVariable int id) {
        newsArticleService.publishNewArticle(id);
        return ResponseEntity.status(200).body("Successfully published");
}
     @GetMapping("get-publish-list")
      public ResponseEntity getPublishList(){
        return ResponseEntity.status(200).body(newsArticleService.getAllNewsArticles());

}
    @GetMapping("get-category-list")
    public ResponseEntity getCategoryList(){
        return ResponseEntity.status(200).body(newsArticleService.getAllNewsArticles());

}

    }

