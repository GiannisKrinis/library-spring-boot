package com.giannis.library.library_api.controller;

import com.giannis.library.library_api.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")

public class BookController{

    private List<Book> books = new ArrayList<>();

    //GET /books
    @GetMapping
    public List<Book> getAllBooks(){
        return books;
    }

    
    //POST /books
    @PostMapping
    public Book addBook(@RequestBody Book book){
        books.add(book);
        return book;
    }


}
