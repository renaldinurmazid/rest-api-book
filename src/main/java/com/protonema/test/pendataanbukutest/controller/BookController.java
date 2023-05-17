package com.protonema.test.pendataanbukutest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.protonema.test.pendataanbukutest.dto.BookRequestDTO;
import com.protonema.test.pendataanbukutest.entity.Book;
import com.protonema.test.pendataanbukutest.service.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/book")
public class BookController {
    
    @Autowired
    BookServiceImpl bookService; 

    // POST
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        if (bookService.addBook(book)) {
            return ResponseEntity.ok("Add book " + book.getTitle() + " successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Add book " + book.getTitle() + " not successfully");
        }
    }

    //GET
    @GetMapping
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }
    @GetMapping
    @RequestMapping("/detail/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }
    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody BookRequestDTO bookRequestDTO) {
        bookRequestDTO.setId(id);
        bookService.update(bookRequestDTO);
        return ResponseEntity.ok("Book updated successfully.");
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean isDeleted = bookService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Book dengan Id " + id + " Berhasil dihapus");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Book dengan Id " + id + " Tidak ditemukan");
        }
    }

    // GET Find by title
    @GetMapping("/search")
    public List<Book> searchBookByTitle(@RequestParam("title") String title) {
        return bookService.searchBookByTitle(title);
    }

    //GET ALL TITLE
    @GetMapping("/title")
    public List<Object[]> findAllTitleWithId() {
        return bookService.findAllTitleWithId();
    }

}
