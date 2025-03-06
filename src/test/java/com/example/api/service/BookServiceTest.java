package com.example.api.service;

import com.example.api.model.Book;
import com.example.api.model.BookReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBook_Success() throws Exception {
        Book book = bookService.getBook("12345");
        assertEquals("12345", book.getIsbn());
        assertEquals("OCP Java", book.getTitle());
    }

    @Test
    public void testGetBook_NotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBook("00000");
        });
        assertEquals("No Book Found with requested isbn number", exception.getMessage());
    }

//    @Test
//    public void testGetAllBooks() {
//        List<Book> books = bookService.getAllBooks();
//        assertEquals(4, books.size());
//    }
}