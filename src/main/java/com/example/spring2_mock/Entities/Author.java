package com.example.spring2_mock.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String gender;
    private double rating;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> bookList  = new ArrayList<>();

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Publish> publishes = new ArrayList<>();
}
