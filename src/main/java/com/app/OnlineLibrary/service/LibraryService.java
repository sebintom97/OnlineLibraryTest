package com.app.OnlineLibrary.service;

import com.app.OnlineLibrary.Repository.LibraryRepository;
import com.app.OnlineLibrary.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    public List<Book> getAllBooks() {
        return libraryRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return libraryRepository.findById(id);
    }

    public Book createBook(Book book) {
        return libraryRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (libraryRepository.existsById(id)) {
            book.setId(id);
            return libraryRepository.save(book);
        }
        return null;
    }

    public boolean deleteBook(Long id) {
        if (libraryRepository.existsById(id)) {
            libraryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
