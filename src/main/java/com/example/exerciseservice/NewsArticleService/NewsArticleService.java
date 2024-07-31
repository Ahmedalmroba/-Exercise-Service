package com.example.exerciseservice.NewsArticleService;

import com.example.exerciseservice.NewsArticle.NewArticle;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsArticleService {
    ArrayList<NewArticle> NewArticles= new ArrayList<>();


    public ArrayList<NewArticle> getAllNewsArticles() {
       return NewArticles;
    }
   public void addNewArticle(NewArticle newArticle) {
        NewArticles.add(newArticle);
    }
    public boolean updateNewArticle(int id, NewArticle newArticle ) {
        for (int i = 0; i < NewArticles.size(); i++) {
            if (NewArticles.get(i).getId() == id) {
                NewArticles.set(i,newArticle);
                return true;
            }
        }
        return false;

    }
    public boolean deleteNewArticle(int id) {
        for (int i = 0; i < NewArticles.size(); i++) {
            if (NewArticles.get(i).getId() == id) {
                NewArticles.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean publishNewArticle(@PathVariable int id) {
        for (int i = 0; i < NewArticles.size(); i++) {
            if (NewArticles.get(i).getId() == id) {
                NewArticles.get(i).setPublished(true);
                NewArticles.get(i).setPublishDate(LocalDate.now());
                return true;

            }
        }

        return  false;

    }

    public ArrayList<NewArticle> getByPulish( ) {
        ArrayList<NewArticle> newArticles = new ArrayList<>();
        for (NewArticle n : NewArticles) {
            if(n.isPublished()){
                newArticles.add(n);
            }


            }
        return newArticles;
        }
        public ArrayList<NewArticle>getCategory(String category) {
            ArrayList<NewArticle> newArticles = new ArrayList<>();
            for (NewArticle l : NewArticles) {
                if (l.getCategory().equals(category)) {
                    newArticles.add(l);

                }

            }
            return newArticles;
        }
    }




