package com.example.spring2_mock.Dto;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String name;
    private int age;
    private String gender;
    private double rating;
}
