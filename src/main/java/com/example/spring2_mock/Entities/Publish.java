package com.example.spring2_mock.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "publish")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String year;

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToOne
    private Book book;

}
