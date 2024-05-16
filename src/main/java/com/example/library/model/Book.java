package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "RELEASEYEAR")
    private LocalDate releaseYear;
    private String description;
    @ManyToOne
    @JoinColumn(name = "AUTHORID")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "STATE")
    private State state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Journal> journals;
}
