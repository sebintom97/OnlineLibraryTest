package com.app.OnlineLibrary.Repository;

import com.app.OnlineLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Book, Long> {
}
