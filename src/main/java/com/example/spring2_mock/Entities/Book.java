package com.example.spring2_mock.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int pages;

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToOne(mappedBy = "book",cascade = CascadeType.ALL)
    private Publish publish;

}
