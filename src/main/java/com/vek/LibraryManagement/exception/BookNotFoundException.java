package com.vek.LibraryManagement.exception;

public class BookNotFoundException  extends RuntimeException{
    public BookNotFoundException(Long id){
        super("Book not found by id "+id);
    }
}
