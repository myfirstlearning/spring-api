package com.example.api.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private UUID bookId;

    private String title;

    private String author;

    private String publisher;

    private String isbn;

    private String description;

    private Double cost;

    private List<BookReview> bookReviews = new ArrayList<>();



}
