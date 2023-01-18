package com.example.project.many.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @SequenceGenerator(name = "book_seq", initialValue = 1, sequenceName = "book_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    private Long id;
    @Column(name = "book_name")
    private String bookName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<AuthorEntity> authorEntity;
}
