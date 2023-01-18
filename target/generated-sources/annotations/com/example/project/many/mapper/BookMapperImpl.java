package com.example.project.many.mapper;

import com.example.project.many.entity.AuthorEntity;
import com.example.project.many.entity.BookEntity;
import com.example.project.many.model.Author;
import com.example.project.many.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-13T15:55:27+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity modelToEntity(Book book) {
        if ( book == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setBookName( book.getBookName() );
        bookEntity.setAuthorEntity( authorListToAuthorEntityList( book.getAuthorEntity() ) );

        return bookEntity;
    }

    @Override
    public Book entityToMode(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        Book book = new Book();

        book.setBookName( bookEntity.getBookName() );
        book.setAuthorEntity( authorEntityListToAuthorList( bookEntity.getAuthorEntity() ) );

        return book;
    }

    @Override
    public List<Book> allEntityToModel(List<BookEntity> bookEntityList) {
        if ( bookEntityList == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( bookEntityList.size() );
        for ( BookEntity bookEntity : bookEntityList ) {
            list.add( entityToMode( bookEntity ) );
        }

        return list;
    }

    protected AuthorEntity authorToAuthorEntity(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorEntity authorEntity = new AuthorEntity();

        authorEntity.setFirstName( author.getFirstName() );
        authorEntity.setLastName( author.getLastName() );

        return authorEntity;
    }

    protected List<AuthorEntity> authorListToAuthorEntityList(List<Author> list) {
        if ( list == null ) {
            return null;
        }

        List<AuthorEntity> list1 = new ArrayList<AuthorEntity>( list.size() );
        for ( Author author : list ) {
            list1.add( authorToAuthorEntity( author ) );
        }

        return list1;
    }

    protected Author authorEntityToAuthor(AuthorEntity authorEntity) {
        if ( authorEntity == null ) {
            return null;
        }

        Author author = new Author();

        author.setFirstName( authorEntity.getFirstName() );
        author.setLastName( authorEntity.getLastName() );

        return author;
    }

    protected List<Author> authorEntityListToAuthorList(List<AuthorEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Author> list1 = new ArrayList<Author>( list.size() );
        for ( AuthorEntity authorEntity : list ) {
            list1.add( authorEntityToAuthor( authorEntity ) );
        }

        return list1;
    }
}
