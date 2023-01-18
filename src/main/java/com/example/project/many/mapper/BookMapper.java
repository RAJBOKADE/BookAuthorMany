package com.example.project.many.mapper;

import com.example.project.many.entity.BookEntity;
import com.example.project.many.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookEntity modelToEntity(Book book);

    Book entityToMode(BookEntity bookEntity);

    List<Book> allEntityToModel(List<BookEntity> bookEntityList);
}
