package com.vek.LibraryManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
    private int availableCopies;

}
