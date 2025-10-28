package com.vek.LibraryManagement.controller;

import com.vek.LibraryManagement.dto.LibraryRequest;
import com.vek.LibraryManagement.dto.LibraryResponse;
import com.vek.LibraryManagement.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService service;

    //    read all
    @GetMapping("/books")
    public ResponseEntity<List<LibraryResponse>> getAllBooks() {
        List<LibraryResponse> lr = service.getAllBooks();
        return ResponseEntity.ok(lr);
    }

    //    ready by id
    @GetMapping("/books/{id}")
    public ResponseEntity<LibraryResponse> getBookById(@PathVariable Long id) {
        LibraryResponse lr = service.getBookById(id);
        return ResponseEntity.ok(lr);
    }

    //create
    @PostMapping("/books")
    public ResponseEntity<LibraryResponse> createBook(@RequestBody @Valid LibraryRequest dto) {

        LibraryResponse lr = service.createBook(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(lr);

    }

    //update
    @PatchMapping("/books/{id}")
    public ResponseEntity<LibraryResponse> updateBookById(@PathVariable Long id,@Valid LibraryRequest dto){
        LibraryResponse lr = service.updateBookById(id,dto);
        return ResponseEntity.ok(lr);
    }

    //delete
    @DeleteMapping("/books/{id}")
    public ResponseEntity<LibraryResponse> deleteBookById(@PathVariable Long id){
        LibraryResponse lr = service.deleteBookById(id);
        return ResponseEntity.ok(lr);
    }
}
