package com.giannis.library.library_api.dto;

public class BookRequestDTO {

    private String title;
    private String author;

    public BookRequestDTO() {}

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}