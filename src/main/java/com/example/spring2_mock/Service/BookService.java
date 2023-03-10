package com.example.spring2_mock.Service;

import com.example.spring2_mock.Dto.BookRequestDto;
import com.example.spring2_mock.Entities.Author;
import com.example.spring2_mock.Entities.Book;
import com.example.spring2_mock.Entities.Publish;
import com.example.spring2_mock.Repository.AuthorRepository;
import com.example.spring2_mock.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){
        Book book = new Book();
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());
        book.setAuthor(bookRequestDto.getAuthor());
        Publish publish = new Publish();
        publish.setYear("2023");
        publish.setBook(book);
        publish.setAuthor(bookRequestDto.getAuthor());
        book.setPublish(publish);
        Author author = bookRequestDto.getAuthor();
        List<Book> bookList = author.getBookList();
        bookList.add(book);
        author.setBookList(bookList);
        List<Publish> publishes = author.getPublishes();
        publishes.add(publish);
        author.setPublishes(publishes);

        authorRepository.save(author);
        bookRepository.save(book);
        return "Book added successfully.";
    }
}
