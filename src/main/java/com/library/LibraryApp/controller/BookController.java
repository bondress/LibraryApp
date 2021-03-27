package com.library.LibraryApp.controller;

import com.library.LibraryApp.dtos.BookRequest;
import com.library.LibraryApp.entities.Book;
import com.library.LibraryApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/v1")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/allBooks")
    public ResponseEntity<Set<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/getBookById/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
        return new ResponseEntity(bookService.getBookById(bookId), HttpStatus.OK);
    }

    @PostMapping("/addBook/{bookId}")
    public ResponseEntity addBook(@RequestBody BookRequest book, @PathVariable int bookId) {
        return new ResponseEntity(bookService.addBook(book, bookId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateBookById/{bookId}")
    public ResponseEntity<Set<Book>> updateBookById(@RequestBody BookRequest book, @PathVariable int bookId) {
        return new ResponseEntity(bookService.updateBookById(book, bookId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteBookById/{bookId}")
    public ResponseEntity<Set<Book>> deleteBookById(@PathVariable int bookId) {
        return new ResponseEntity(bookService.deleteBookById(bookId), HttpStatus.OK);
    }
}
