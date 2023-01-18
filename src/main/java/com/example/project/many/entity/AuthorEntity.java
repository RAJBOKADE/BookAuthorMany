package com.example.project.many.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {
    @Id
    @SequenceGenerator(name = "author_seq", initialValue = 1, sequenceName = "author_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToMany(mappedBy = "authorEntity")
    private List<BookEntity> bookEntity;

}
