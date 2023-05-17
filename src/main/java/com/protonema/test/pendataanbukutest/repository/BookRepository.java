package com.protonema.test.pendataanbukutest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.protonema.test.pendataanbukutest.entity.Book;

import jakarta.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Long>{

    @Transactional
    @Modifying

    @Query(value = "UPDATE book SET title=:title, author=:author, publisher=:publisher, publicationYear=:publicationYear,  WHERE book_id=:id", nativeQuery = true)  
    public void update(@Param("title") String title, @Param("author") String author, @Param("publisher") String publisher, @Param("publicationYear") Long publicationYear, @Param("id") Long id);

    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> getAllBook();

    @Query(value = "SELECT b FROM Book b WHERE b.id = :id")
    Optional<Book> getBookById(@Param("id") Long id);

    @Query(value = "SELECT b FROM Book b WHERE b.title = :title")
    List<Book> searchBookByTitle(@Param("title") String title);

    @Query(value = "SELECT b.bookId, b.title FROM Book b")
    List<Object[]> findAllTitleWithId();

}
