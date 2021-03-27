package com.library.LibraryApp.service.seviceImpl;

import com.library.LibraryApp.dtos.BookRequest;
import com.library.LibraryApp.entities.Book;
import com.library.LibraryApp.service.BookService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private Set<Book> books = new HashSet<>();

    @Override
    public Set<Book> addBook(BookRequest book, int bookId) {
        books.add(new Book(bookId, book.getTitle()));
        return  books;
    }

    public Book getBookById(int bookId) {
        Book bookToGet = null;
        for(Book singleBook : books){
            if(singleBook.getId() == bookId){
                bookToGet = new Book(bookId, singleBook.getTitle());
                break;
            }
        }
        return bookToGet;
    }

    public Set<Book> getAllBooks() {
        return books;
    }

    public Book updateBookById(BookRequest book, int bookId) {
        Book bookUpdated = null;
        for (Book singleBook : books) {
            if(singleBook.getId() == bookId){
                singleBook.setTitle(book.getTitle());
                books.add(singleBook);
                bookUpdated = singleBook;
                break;
            }
        }
        return bookUpdated;
    }

    public Set<Book> deleteBookById(int bookId) {
        for (Book singleBook: books) {
            if(singleBook.getId() == bookId){
                books.remove(singleBook);
                break;
            }
        }
        return books;
    }
}
