package com.vek.LibraryManagement.service;

import com.vek.LibraryManagement.dto.LibraryRequest;
import com.vek.LibraryManagement.dto.LibraryResponse;

import java.util.List;

public interface LibraryService {
    List<LibraryResponse> getAllBooks();
    LibraryResponse getBookById(Long id);
    LibraryResponse createBook(LibraryRequest dto);
    LibraryResponse updateBookById(Long id,LibraryRequest dto);
    LibraryResponse deleteBookById(Long id);

}
