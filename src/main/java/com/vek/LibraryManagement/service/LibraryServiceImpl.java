package com.vek.LibraryManagement.service;

import com.vek.LibraryManagement.dto.LibraryRequest;
import com.vek.LibraryManagement.dto.LibraryResponse;
import com.vek.LibraryManagement.exception.BookNotFoundException;
import com.vek.LibraryManagement.model.LibraryEntity;
import com.vek.LibraryManagement.repo.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepo repo;

    //    get all book
    @Override
    public List<LibraryResponse> getAllBooks() {
        List<LibraryEntity> db = repo.findAll();
        List<LibraryResponse> lr = new ArrayList<>();

        for (LibraryEntity s : db) {
            lr.add(LibraryResponse.builder().id(s.getId()).title(s.getTitle()).author(s.getAuthor()).isbn(s.getIsbn())
                    .publishedDate(s.getPublishedDate()).availableCopies(s.getAvailableCopies()).build());

        }

        return lr;
    }

//    get book by id

    @Override
    public LibraryResponse getBookById(Long id) {
        LibraryEntity db = repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        return LibraryResponse.builder().id(db.getId()).title(db.getTitle()).author(db.getAuthor()).isbn(db.getIsbn()).
                publishedDate(db.getPublishedDate()).availableCopies(db.getAvailableCopies()).build();

    }

    //create book
    public LibraryResponse createBook(LibraryRequest dto) {

        LibraryEntity db = LibraryEntity.builder().title(dto.getTitle()).author(dto.getAuthor()).isbn(dto.getIsbn()).publishedDate(dto.getPublishedDate())
                .availableCopies(dto.getAvailableCopies()).build();

        LibraryEntity saved = repo.save(db);
        return LibraryResponse.builder().id(saved.getId()).title(saved.getTitle()).author(saved.getAuthor()).isbn(saved.getIsbn()).publishedDate(saved.getPublishedDate())
                .availableCopies(saved.getAvailableCopies()).build();

    }

//update by id

    @Override
    public LibraryResponse updateBookById(Long id,LibraryRequest dto){
        LibraryEntity db = repo.findById(id).orElseThrow(()->new BookNotFoundException(id));
        db.setTitle(dto.getTitle());
        db.setAuthor(dto.getAuthor());
        db.setIsbn(dto.getIsbn());
        db.setPublishedDate(dto.getPublishedDate());
        db.setAvailableCopies(dto.getAvailableCopies());
        LibraryEntity saved = repo.save(db);
        return LibraryResponse.builder().title(saved.getTitle()).author(saved.getAuthor()).isbn(saved.getIsbn()).publishedDate(saved.getPublishedDate())
                .availableCopies(saved.getAvailableCopies()).build();
    }

//    delete by id
    @Override
    public LibraryResponse deleteBookById(Long id){
        LibraryEntity db = repo.findById(id).orElseThrow(()->new BookNotFoundException(id));
        repo.delete(db);
        return LibraryResponse.builder().id(db.getId()).title(db.getTitle()).author(db.getAuthor()).isbn(db.getIsbn()).publishedDate(db.getPublishedDate()).
                availableCopies(db.getAvailableCopies()).build();
    }
}
