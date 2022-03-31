package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Book;

public interface BookRepository extends JpaRepository<Book, String>{

	List<Book> findByAuthor(String author);

	List<Book> findByTitle(String title);

}
