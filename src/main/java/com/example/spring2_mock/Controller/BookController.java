package com.example.spring2_mock.Controller;

import com.example.spring2_mock.Dto.BookRequestDto;
import com.example.spring2_mock.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody BookRequestDto bookRequestDto){
        return new ResponseEntity<>(bookService.addBook(bookRequestDto), HttpStatus.CREATED);
    }
}
