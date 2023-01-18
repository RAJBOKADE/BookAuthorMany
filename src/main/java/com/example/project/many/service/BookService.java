package com.example.project.many.service;

import com.example.project.many.entity.BookEntity;
import com.example.project.many.mapper.BookMapper;
import com.example.project.many.model.Book;
import com.example.project.many.model.BookResponse;
import com.example.project.many.repository.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookService(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public BookResponse addBook(Book book) {
        BookEntity bookEntity = null;
        bookEntity = bookMapper.modelToEntity(book);
        bookRepository.save(bookEntity);
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(bookEntity.getId());
        log.info("book add with id {} ", bookResponse);
        return bookResponse;
    }

    public Book getById(Long id) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findByIdQuery(id);
        Book book = new Book();
        if (bookEntityOptional.isPresent()) {
            book = bookMapper.entityToMode(bookEntityOptional.get());
            log.info("book find with id {}", id);
        } else {
            log.info("book with id {} not found", id);
        }
        return book;
    }

    public void deleteById(Long id) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);
        if (bookEntityOptional.isPresent()) {
            bookRepository.deleteById(id);
            log.info("delete with id {} successfull", id);
        } else {
            log.info("id {} not found");
        }
    }


    public void updateBookById(Long id, Book book) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);
        if (bookEntityOptional.isPresent()) {
            BookEntity bookEntity = bookEntityOptional.get();
            bookEntity = bookMapper.modelToEntity(book);
            bookEntity.setId(id);
            bookRepository.save(bookEntity);
            log.info("update with id {} successfull", id);
        } else {
            log.info("id {} not found");
        }
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = bookMapper.allEntityToModel(bookRepository.findAll());
        log.info("get all successfully");
        return bookList;
    }

}