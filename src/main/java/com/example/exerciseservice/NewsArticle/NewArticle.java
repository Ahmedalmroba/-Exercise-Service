package com.example.exerciseservice.NewsArticle;

import ch.qos.logback.core.util.Loader;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewArticle {
@NotNull(message ="Cannot be nul" )
        private int id;

        @NotEmpty(message = "title Cannot be nul")
        @Size(max = 100)
        private String title;

        @NotEmpty
        @Size(min = 5, max = 20)
        private String author;

        @NotEmpty
        @Size(min = 200)
        private String content;

        @NotEmpty
        @Pattern(regexp = "^(politics|sports|technology)$")
        private String category;

        @NotEmpty
        private String imageUrl;


        @AssertFalse
        private boolean isPublished;

        private LocalDate publishDate;
    }

