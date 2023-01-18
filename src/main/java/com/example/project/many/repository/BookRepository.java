package com.example.project.many.repository;

import com.example.project.many.entity.BookEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

//@Query(value = "select b.bookName from BookEntity b where id=?1")
//    Optional<BookEntity> findByIdQuery(Long id);


    @Query("select b from BookEntity b left join fetch b.authorEntity where b.id=:id")
    Optional<BookEntity> findByIdQuery(Long id);

    @EntityGraph(attributePaths = "authorEntity")
    Optional<BookEntity> findAuthorById(Long id);
}
