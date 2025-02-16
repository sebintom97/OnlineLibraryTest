package com.app.OnlineLibrary.controller;

import com.app.OnlineLibrary.model.Book;
import com.app.OnlineLibrary.service.LibraryRapidApi;
import com.app.OnlineLibrary.service.LibraryService;
import com.app.OnlineLibrary.service.OpenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/library")
public class BookController {
    @Autowired
    private LibraryService libraryService;

    @Autowired
    private OpenApiService openApiService;

    @Autowired
    private LibraryRapidApi libraryRapidApi;


    @GetMapping
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = libraryService.getBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/top-authors")
    public String getTopAuthors() {
        // Call the ApiService method to fetch top authors from the external API
        return libraryRapidApi.getTopAuthors();
    }

    @GetMapping("/summary")
    public String getBookSummary(@RequestParam String title, @RequestParam String author) {
        return openApiService.getBookSummary(title, author);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = libraryService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = libraryService.updateBook(id, book);
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        return libraryService.deleteBook(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
