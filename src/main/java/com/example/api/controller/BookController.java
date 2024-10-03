package com.example.api.controller;


import com.example.api.model.Book;
import com.example.api.model.BookRequest;
import com.example.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book-app")
public class BookController {

    @Autowired
   BookService bookService;


    //http://localhost:8080/spring-api/book-app/requestedBook/98765
    @GetMapping( "/requestedBook/{isbn}")
    public Book getBookByPathVariable(@PathVariable String isbn) throws Exception {

        Book book = bookService.getBook(isbn);

        return book;
    }

//    curl --location 'http://localhost:8080/spring-api/book-app/requestedBookWithHeaders/98765' \
//            --header 'Override: true'
    @GetMapping( "/requestedBookWithHeaders/{isbn}")
    public Book getBookByPathVariableHeaders(@PathVariable String isbn,
                                             @RequestHeader(value = "Override") boolean override) throws Exception {

        System.out.println("Override Flag : " + override);
        Book book = bookService.getBook(isbn);

        return book;
    }


    //http://localhost:8080/spring-api/book-app/requestedBook?isbn=98765
    @GetMapping( "/requestedBook")
    public Book getBookByReqParam(@RequestParam String isbn) throws Exception {

        Book book = bookService.getBook(isbn);

        return book;
    }

    @GetMapping( "/requestedBookByMatrixVar")
    public Book getBookByMatrixVariable(@MatrixVariable String isbn,
                                        @MatrixVariable String title) throws Exception {

        Book book = bookService.getBook(isbn);

        return book;
    }

//     curl --location --request GET 'http://localhost:8080/spring-api/book-app/requestedBookByReqBody' \
//            --header 'Content-Type: application/json' \
//            --data '{
//            "isbn":"98765"
//     }'
    @GetMapping( "/requestedBookByReqBody")
    public Book getBookByRequestBody(@RequestBody BookRequest bookRequest) throws Exception {

        Book book = bookService.getBook(bookRequest.getIsbn());

        return book;
    }

}
