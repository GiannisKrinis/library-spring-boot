package com.giannis.library.library_api.service;

import com.giannis.library.library_api.dto.BookRequestDTO;
import com.giannis.library.library_api.dto.BookResponseDTO;
import com.giannis.library.library_api.model.Book;
import com.giannis.library.library_api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponseDTO> getAllBooks(){

        List<Book> books = bookRepository.findAll();
        List<BookResponseDTO> responseList = new ArrayList<>();

        for(Book book : books){
            BookResponseDTO dto = new BookResponseDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setAuthor(book.getAuthor());

            responseList.add(dto);
        }
        return responseList;
    }

    public BookResponseDTO addBook(BookRequestDTO requestDTO) {
        //DTO---->ENTITY
        Book book = new Book();
        book.setTitle(requestDTO.getTitle());
        book.setAuthor(requestDTO.getAuthor());

        //SAVE
        Book savedBook = bookRepository.save(book);

        //ENTITY ---->DTO
        BookResponseDTO responseDTO = new BookResponseDTO();
        responseDTO.setId(savedBook.getId());
        responseDTO.setTitle(savedBook.getTitle());
        responseDTO.setAuthor(savedBook.getAuthor());
        
        return responseDTO;
    }
}

