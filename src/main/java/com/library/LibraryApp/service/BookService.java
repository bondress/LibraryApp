package com.library.LibraryApp.service;

import com.library.LibraryApp.dtos.BookRequest;
import com.library.LibraryApp.entities.Book;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BookService {
    Set<Book> addBook(BookRequest request, int bookId);

    Book getBookById(int bookId);

    Set<Book> getAllBooks();

    Book updateBookById(BookRequest book, int bookId);

    Set<Book> deleteBookById(int bookId);
}