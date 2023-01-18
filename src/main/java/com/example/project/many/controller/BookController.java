package com.example.project.many.controller;

import com.example.project.many.model.Book;
import com.example.project.many.model.BookResponse;
import com.example.project.many.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> addBook(@RequestBody Book book) {
        log.info("Posting data");
        BookResponse bookResponse = bookService.addBook(book);
       return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Book book = bookService.getById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        log.info("started deleting the record..");
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/books/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        log.info("started updating");
        bookService.updateBookById(id, book);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> getall() {
        List<Book> bookList = bookService.getAllBooks();
        log.info("started get all");
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

}