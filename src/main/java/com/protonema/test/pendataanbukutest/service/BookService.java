package com.protonema.test.pendataanbukutest.service;

import java.util.List;
import java.util.Optional;

import com.protonema.test.pendataanbukutest.entity.Book;
import com.protonema.test.pendataanbukutest.dto.BookRequestDTO;

public interface BookService {
    //Get
    public List<Book> getAllBook();
    public Optional<Book> getBookById(Long id);
    List<Book> searchBookByTitle(String title);
    List<Object[]> findAllTitleWithId();
    
    //POST    
    public boolean addBook(Book book );
    
    //PUT
    void update(BookRequestDTO bookRequestDTO);
    
    //DELETE
    public boolean deleteById(Long id);
}
