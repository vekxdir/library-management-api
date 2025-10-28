package com.vek.LibraryManagement.repo;

import com.vek.LibraryManagement.model.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<LibraryEntity,Long> {
}
