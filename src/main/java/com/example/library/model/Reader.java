package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "READERS")
public class Reader {
    @Id
    private String number;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reader")
    private List<Reader> readers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Book> books;
}
