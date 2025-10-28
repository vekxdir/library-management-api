package com.vek.LibraryManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=100)
    private String title;
    @Column(nullable=false,length=75)
    private String author;
    @Column(nullable=false,length=13)
    private String isbn;
    @Column(nullable=false)
    private LocalDate publishedDate;
    @Column(nullable=false)
    private int availableCopies;
}
