package com.suncap.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findByTitleContaining(String title);
	
}
