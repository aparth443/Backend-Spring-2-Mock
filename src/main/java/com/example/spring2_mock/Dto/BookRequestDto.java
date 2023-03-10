package com.example.spring2_mock.Dto;

import com.example.spring2_mock.Entities.Author;
import lombok.Data;

@Data
public class BookRequestDto {
    private String name;
    private int pages;
    private Author author;
}
