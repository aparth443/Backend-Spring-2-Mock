package com.example.spring2_mock.Controller;

import com.example.spring2_mock.Dto.AuthorRequestDto;
import com.example.spring2_mock.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return new ResponseEntity<>(authorService.addAuthor(authorRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<Map<String,Integer>> getAuthorWithMaximumPages(){
        return new ResponseEntity<>(authorService.getAuthorWithMaximumPages(),HttpStatus.OK);
    }

    @GetMapping("/getMaxBookCount")
    public ResponseEntity<Integer> noOfBooks(@RequestParam("authorId") int authorId, @RequestParam("year") String year){
        return new ResponseEntity<>(authorService.noOfBooks(authorId,year),HttpStatus.OK);
    }
}
