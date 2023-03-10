package com.example.spring2_mock.Service;

import com.example.spring2_mock.Dto.AuthorRequestDto;
import com.example.spring2_mock.Entities.Author;
import com.example.spring2_mock.Entities.Book;
import com.example.spring2_mock.Entities.Publish;
import com.example.spring2_mock.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(AuthorRequestDto authorRequestDto){
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setGender(authorRequestDto.getGender());
        author.setRating(authorRequestDto.getRating());

        authorRepository.save(author);

        return "Author added successfully.";
    }

    public Map<String, Integer> getAuthorWithMaximumPages(){
        Map<String,Integer> map = new HashMap<>();
        String authorName = "";
        int authorAge = 0;
        List<Author> authorList = authorRepository.findAll();
        int noOfPages = 0;
        for(Author author: authorList){
            List<Book> bookList = author.getBookList();
            int pages = 0;
            for(Book book: bookList){
                pages += book.getPages();
            }
            if(pages>noOfPages){
                authorName = author.getName();
                authorAge = author.getAge();
                noOfPages = pages;
            }
        }
        map.put(authorName,authorAge);
        return map;
    }

    public Integer noOfBooks(int authorId,String year){
        Author author = authorRepository.findById(authorId).get();
        List<Publish> publishes = author.getPublishes();

        int cnt = 0;
        for(Publish publish: publishes){
            if(year.equals(publish.getYear())){
                cnt++;
            }
        }
        return cnt;
    }
}
