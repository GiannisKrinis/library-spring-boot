package com.giannis.library.library_api.controller;

import com.giannis.library.library_api.dto.BookRequestDTO;
import com.giannis.library.library_api.dto.BookResponseDTO;
import com.giannis.library.library_api.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")

public class BookController{
    
    //With service stereotype spring gives instance of the object BookService
    private final BookService bookService;
    

    //Constructor 
    public BookController (BookService bookService){
        this.bookService = bookService;
    }

    //GET /books
    @GetMapping
    public List <BookResponseDTO> getBooks(){
        return bookService.getAllBooks();
    }

    
    //POST /books
    @PostMapping
    public BookResponseDTO addBook(@RequestBody BookRequestDTO requestDTO){
        return bookService.addBook(requestDTO);
    }


}
