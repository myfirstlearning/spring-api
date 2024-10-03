package com.example.api.service;


import com.example.api.model.Book;
import com.example.api.model.BookReview;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BookService {


    public Book getBook(String isbn) throws Exception {
        Book book = getAllBooks().stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Book Found with requested isbn number"));
       return book;
    }

    private List<Book> getAllBooks() {

        return List.of(
                new Book().builder().bookId(UUID.randomUUID())
                .isbn("12345")
                .title("OCP Java")
                .cost(20.0)
                .publisher("Oracle")
                .bookReviews(List.of(new BookReview("Good", 3),
                        new BookReview("Better", 4))).build(),
                new Book().builder().bookId(UUID.randomUUID())
                        .isbn("98765")
                        .title("Spring").cost(30.0)
                        .publisher("Spring Community")
                        .bookReviews(List.of(new BookReview("Best", 5),
                                new BookReview("Better", 4))).build(),
                new Book().builder().bookId(UUID.randomUUID())
                        .isbn("56789")
                        .title("React").cost(25.0)
                        .publisher("Angular University")
                        .bookReviews(List.of(new BookReview("Good", 3),
                                new BookReview("Better", 4))).build(),
                new Book().builder().bookId(UUID.randomUUID())
                        .isbn("56789")
                        .title("Python").cost(25.0)
                        .publisher("Python Developers")
                        .bookReviews(List.of(new BookReview("Best", 5),
                                new BookReview("Better", 4))).build());
    }

}
