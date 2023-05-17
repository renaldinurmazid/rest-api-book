package com.protonema.test.pendataanbukutest.service;

import java.util.List;
import java.util.Optional;

import com.protonema.test.pendataanbukutest.entity.Book;
import com.protonema.test.pendataanbukutest.dto.BookRequestDTO;

public interface BookService {
    public boolean addBook(Book book );
    public List<Book> getAllBook();
    public Optional<Book> getBookById(Long id);
    void update(BookRequestDTO bookRequestDTO);
    public boolean deleteById(Long id);
    List<Book> searchBookByTitle(String title);
    List<Object[]> findAllTitleWithId();
}
