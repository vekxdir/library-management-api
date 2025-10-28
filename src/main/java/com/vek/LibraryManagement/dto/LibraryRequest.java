package com.vek.LibraryManagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryRequest {

    @NotBlank(message="title is required")
    private String title;
    @NotBlank(message="author is required")
    private String author;
    @NotBlank(message="isbn number is required")
    private String isbn;
    @PastOrPresent(message="published date cannot be in the future")
    private LocalDate PublishedDate;
    @Min(value=1,message="available copies must be at least 1")
    private int availableCopies;

}
