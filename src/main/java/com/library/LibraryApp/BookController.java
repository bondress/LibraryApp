package com.library.LibraryApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class BookController {
    private Set<Book> books = new HashSet<>();

    @GetMapping("v1/allBooks")
    public ResponseEntity<Set<Book>> getAllBooks() {

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("v1/getBookById/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
        Book bookToGet = null;
        for(Book singleBook : books){
            if(singleBook.getId() == bookId){
                bookToGet = new Book(bookId, singleBook.getTitle());
                break;
            }
        }
        return new ResponseEntity(bookToGet, HttpStatus.OK);
    }

    @PostMapping("v1/addBook/{bookId}")
    public ResponseEntity addBook(@RequestBody BookRequest book, @PathVariable int bookId) {
        books.add(new Book(bookId, book.getTitle()));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PutMapping("v1/updateBookById/{bookId}")
    public ResponseEntity<Set<Book>> updateBookById(@RequestBody BookRequest book, @PathVariable int bookId) {
        for (Book singleBook: books) {
            if(singleBook.getId() == bookId){
                singleBook.setTitle(book.getTitle());
                break;
            }
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("v1/deleteBookById/{bookId}")
    public ResponseEntity<Set<Book>> deleteBookById(@PathVariable int bookId) {
        for (Book singleBook: books) {
            if(singleBook.getId() == bookId){
                books.remove(singleBook);
                break;
            }
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
