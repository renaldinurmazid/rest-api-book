package com.protonema.test.pendataanbukutest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protonema.test.pendataanbukutest.entity.Book;
import com.protonema.test.pendataanbukutest.repository.BookRepository;
import com.protonema.test.pendataanbukutest.service.BookService;
import com.protonema.test.pendataanbukutest.dto.BookRequestDTO;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    //POST
    @Override
    public boolean addBook(Book book) {
        bookRepository.save(book);
        return true;
    }  
    //GET
    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.getBookById(id);
    }
    //PUT
    @Override
    public void update(BookRequestDTO bookRequestDTO) {
        Book book = bookRepository.findById(bookRequestDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + bookRequestDTO.getId()));

        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setPublisher(bookRequestDTO.getPublisher());
        book.setPublicationYear(bookRequestDTO.getPublicationYear());

        bookRepository.save(book);
    }
    //DELETE
    @Override
    public boolean deleteById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    //GET
    @Override  
    public List<Book> searchBookByTitle(String title) {
        return bookRepository.searchBookByTitle(title);
    }
    //GET
    @Override
    public List<Object[]> findAllTitleWithId() {
        return bookRepository.findAllTitleWithId();
    }
}
